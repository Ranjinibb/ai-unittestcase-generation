package com.example.helloworld.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(controllers = HelloWorldController.class)
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHelloWorld() throws Exception {
        mockMvc.perform(get("/helloWorld"))
              .andExpect(status().isOk())
              .andExpect(content().string("Hello, World!"));
    }

    @Test
    public void testHelloWorldOne() throws Exception {
        mockMvc.perform(get("/helloWorldOne"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello, World!"));
    }

    @Test
    public void testHelloWorldTwo() throws Exception {
        mockMvc.perform(get("/helloWorldTwo"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello, World!"));
    }

    @Test
    public void testHelloWorldThree() throws Exception {
        mockMvc.perform(get("/helloWorldThree"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello, World!"));
    }
}
