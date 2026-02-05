package com.example.helloworld.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(controllers = HelloWorldSecondController.class)
public class HelloWorldSecondControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSendGreetings() throws Exception {
        mockMvc.perform(get("/sendGreetings"))
              .andExpect(status().isOk())
              .andExpect(content().string("sendGreetings!"));
    }

    @Test
    public void testSendGreetingsOne() throws Exception {
        mockMvc.perform(get("/sendGreetingsOne"))
              .andExpect(status().isOk())
               .andExpect(content().string("sendGreetingsOne!"));
    }

    @Test
    public void testSendGreetingsTwo() throws Exception {
        mockMvc.perform(get("/sendGreetingsTwo"))
               .andExpect(status().isOk())
               .andExpect(content().string("sendGreetingsTwo!"));
    }
}
