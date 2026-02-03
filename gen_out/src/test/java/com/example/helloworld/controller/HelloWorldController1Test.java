```java
// src/test/java/com/example/helloworld/controller/HelloWorldController1Test.java
package com.example.helloworld.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloWorldController1Test {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testSendGreetings() {
        ResponseEntity<String> response = restTemplate.getForEntity("/hell", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo("Hello, World!");
    }

    @Test
    public void testSendGreetings1() {
        ResponseEntity<String> response = restTemplate.getForEntity("/hell1", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo("Hello, World!");
    }

    @Test
    public void testSendGreetings2() {
        ResponseEntity<String> response = restTemplate.getForEntity("/hell2", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo("Hello, World!");
    }

    @Test
    public void testSendGreetings3() {
        ResponseEntity<String> response = restTemplate.getForEntity("/hell3", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo("Hello, World!");
    }
}
```
