```java
// src/test/java/com/example/helloworld/controller/HelloWorldControllerTest.java
package com.example.helloworld.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HelloWorldControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testSendGreetings() {
        ResponseEntity<String> response = restTemplate.getForEntity("/hello", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo("Hello, World!");
    }

    @Test
    public void testSendGreetings1() {
        ResponseEntity<String> response = restTemplate.getForEntity("/hello1", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo("Hello, World!");
    }

    @Test
    public void testSendGreetings2() {
        ResponseEntity<String> response = restTemplate.getForEntity("/hello2", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo("Hello, World!");
    }

    @Test
    public void testSendGreetings3() {
        ResponseEntity<String> response = restTemplate.getForEntity("/hello3", String.class);
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).isEqualTo("Hello, World!");
    }
}
