package com.example.helloworld.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(controllers = HelloWorldController1.class)
public class HelloWorldController1Test {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSendGreetings() throws Exception {
        mockMvc.perform(get("/hell"))
              .andExpect(status().isOk())
               .andExpect(content().string("Hello, World!"));
    }

    @Test
    public void testSendGreetings1() throws Exception {
        mockMvc.perform(get("/hell1"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello, World!"));
    }

    @Test
    public void testSendGreetings2() throws Exception {
        mockMvc.perform(get("/hell2"))
               .andExpect(status().isOk())
              .andExpect(content().string("Hello, World!"));
    }

    @Test
    public void testSendGreetings3() throws Exception {
        mockMvc.perform(get("/hell3"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello, World!"));
    }

    @Test
    public void testSendGreetings4() throws Exception {
        mockMvc.perform(get("/hell4"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello, World!"));
    }

    @Test
    public void testSendGreetings5() throws Exception {
        mockMvc.perform(get("/hell5"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello, World!"));
    }

    @Test
    public void testSendGreetings6() throws Exception {
        mockMvc.perform(get("/hell6"))
               .andExpect(status().isOk())
               .andExpect(content().string("Hello, World!"));
    }
}
