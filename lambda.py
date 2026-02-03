import base64
import io
import json
import os
import re
import zipfile
import boto3

# ---- Bedrock client (region should match your model availability) ----
bedrock = boto3.client("bedrock-runtime", region_name=os.getenv("AWS_REGION", "us-east-1"))
MODEL_ID = os.getenv("MODEL_ID", "amazon.nova-lite-v1:0")

# ---- Strict system prompt: raw Java only, MockMvc-only ----
PROMPT = """
You MUST output ONLY valid Java code. Absolutely NO markdown, NO backticks, NO fences.

STRICT RULES:
- Output exactly ONE complete .java file and nothing else.
- First line must be: package <package>;
- Use ONLY Spring MVC MockMvc + @WebMvcTest(controllers = <Controller>.class).
- DO NOT use WebTestClient. DO NOT use @SpringBootTest.
- Include all necessary imports:
  - import org.junit.jupiter.api.Test;
  - import org.springframework.beans.factory.annotation.Autowired;
  - import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
  - import org.springframework.test.web.servlet.MockMvc;
  - import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
  - import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
  - import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
- Use valid MockMvc syntax, e.g.:
    mockMvc.perform(get("/path"))
           .andExpect(status().isOk())
           .andExpect(content().string("..."));
- Only test endpoints that actually exist in the provided controller code.
- Ensure braces are balanced and the file compiles on Java 21.
"""

PKG_RE = re.compile(r'^\s*package\s+([a-zA-Z0-9_.]+)\s*;', re.MULTILINE)

def build_messages(path: str, content: str) -> dict:
    controller = os.path.splitext(os.path.basename(path))[0]
    return {
        "schemaVersion": "messages-v1",
        "system": [{"text": PROMPT}],
        "messages": [
            {
                "role": "user",
                "content": [
                    {
                        "text": (
                            f"FILE PATH: {path}\n"
                            f"<CODE>\n{content}\n</CODE>\n\n"
                            f"Generate a MockMvc-based JUnit 5 test named {controller}Test."
                        )
                    }
                ],
            }
        ],
        "inferenceConfig": {
            "maxTokens": int(os.getenv("MAX_TOKENS", "1500")),
            "temperature": float(os.getenv("TEMPERATURE", "0.2")),
            "topP": float(os.getenv("TOP_P", "0.9")),
            "topK": int(os.getenv("TOP_K", "20")),
        },
    }

def extract_text(resp_json: dict) -> str:
    """Concatenate text blocks from Nova messages-v1 response."""
    out = resp_json.get("output", {})
    msg = out.get("message", {}) or {}
    blocks = msg.get("content", []) or []
    text = "".join(b.get("text", "") for b in blocks if isinstance(b, dict))
    return (text or "").strip()

def package_from_content_or_path(content: str, path: str) -> str:
    """Prefer package from source content; fallback to path under src/main/java."""
    m = PKG_RE.search(content or "")
    if m:
        return m.group(1)
    # fallback from path structure
    if "src/main/java/" in path:
        pkg_path = path.split("src/main/java/")[1]
        pkg_dir = os.path.dirname(pkg_path).replace("/", ".").strip(".")
        return pkg_dir or ""
    return ""

def ensure_package_header(java_text: str, pkg: str) -> str:
    if not pkg:
        return java_text
    if not PKG_RE.search(java_text):
        java_text = f"package {pkg};\n\n{java_text}"
    return java_text

def strip_markdown_fences(text: str) -> str:
    # Remove ```java ... ``` or any ``` fences defensively
    return text.replace("```java", "").replace("```", "").strip()

def lambda_handler(event, context):
    # Allow both direct dict and JSON string
    body = event if isinstance(event, dict) else json.loads(event or "{}")
    files = body.get("files", [])
    if not files:
        return {"statusCode": 200, "zip_base64": "", "files_written": 0}

    mem = io.BytesIO()
    written = 0

    with zipfile.ZipFile(mem, "w", compression=zipfile.ZIP_DEFLATED) as zf:
        for f in files:
            path = f.get("path")
            content = f.get("content", "")
            if not path or not content:
                continue

            # Build request and invoke model
            payload = build_messages(path, content)
            resp = bedrock.invoke_model(
                modelId=MODEL_ID,
                body=json.dumps(payload),
                contentType="application/json",
                accept="application/json",
            )
            resp_json = json.loads(resp["body"].read())
            java = extract_text(resp_json)

            # Hard-guard against fences even if the model slips
            java = strip_markdown_fences(java)

            # Ensure we have a package header (model is instructed to include it)
            pkg = package_from_content_or_path(content, path)
            if pkg and not PKG_RE.search(java):
                java = ensure_package_header(java, pkg)

            # Compute output path: src/test/java/<pkg>/<Controller>Test.java
            controller = os.path.splitext(os.path.basename(path))[0]
            pkg_path = pkg.replace(".", "/") if pkg else ""
            out_rel = (
                f"src/test/java/{pkg_path}/{controller}Test.java"
                if pkg_path else f"src/test/java/{controller}Test.java"
            )

            if java:
                # Ensure newline at EOF for nicer diffs/compilers
                if not java.endswith("\n"):
                    java += "\n"
                zf.writestr(out_rel, java)
                written += 1

    zip_b64 = base64.b64encode(mem.getvalue()).decode("utf-8") if written else ""
    return {"statusCode": 200, "zip_base64": zip_b64, "files_written": written}