package com.example.helloworld.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@WebMvcTest(controllers = HelloWorldThirdController.class)
public class HelloWorldThirdControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSendGreetings() throws Exception {
        mockMvc.perform(get("/thirdCtrl"))
               .andExpect(status().isOk())
              .andExpect(content().string("sendGreetings!"));
    }

    @Test
    public void testSendGreetingsOne() throws Exception {
        mockMvc.perform(get("/thirdCtrlOne"))
               .andExpect(status().isOk())
               .andExpect(content().string("sendGreetingsOne!"));
    }

    @Test
    public void testSendGreetingsTwo() throws Exception {
        mockMvc.perform(get("/thirdCtrlTwo"))
               .andExpect(status().isOk())
               .andExpect(content().string("sendGreetingsOne!"));
    }
}
