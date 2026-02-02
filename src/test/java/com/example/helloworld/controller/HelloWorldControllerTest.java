// src/test/java/com/example/helloworld/controller/HelloWorldControllerTest.java

package com.example.helloworld.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSendGreetings() throws Exception {
        mockMvc.perform(get("/hello"))
               .andExpect(status().isOk())
                .andExpect(content().string("Hello, World!"));
    }

    @Test
    public void testSendGreetings1() throws Exception {
        mockMvc.perform(get("/hello1"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello, World!"));
    }

    @Test
    public void testSendGreetings2() throws Exception {
        mockMvc.perform(get("/hello2"))
                .andExpect(status().isOk())
               .andExpect(content().string("Hello, World!"));
    }

    @Test
    public void testSendGreetings3() throws Exception {
        mockMvc.perform(get("/hello3"))
                .andExpect(status().isOk())
               .andExpect(content().string("Hello, World!"));
    }

    @Test
    public void testSendGreetings4() throws Exception {
        mockMvc.perform(get("/hello4"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello, World!"));
    }

    @Test
    public void testSendGreetings5() throws Exception {
        mockMvc.perform(get("/hello5"))
                .andExpect(status().isOk())
               .andExpect(content().string("Hello, World!"));
    }
}
