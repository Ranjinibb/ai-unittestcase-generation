```java
// src/test/java/com/example/helloworld/controller/HelloWorldControllerTest.java
package com.example.helloworld.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class HelloWorldControllerTest {

    @Autowired
    private HelloWorldController helloWorldController;

    @Test
    void testSendGreetings() {
        assertThat(helloWorldController.sendGreetings()).isEqualTo("Hello, World!");
    }

    @Test
    void testSendGreetings1() {
        assertThat(helloWorldController.sendGreetings1()).isEqualTo("Hello, World!");
    }

    @Test
    void testSendGreetings2() {
        assertThat(helloWorldController.sendGreetings2()).isEqualTo("Hello, World!");
    }

    @Test
    void testSendGreetings3() {
        assertThat(helloWorldController.sendGreetings3()).isEqualTo("Hello, World!");
    }
}
```
