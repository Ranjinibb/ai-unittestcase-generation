package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldSecondController {

    @GetMapping("/sendGreetings")
    public String sendGreetings() {
        return "sendGreetings!";
    }

    @GetMapping("/sendGreetingsOne")
    public String sendGreetingsOne() {
        return "sendGreetingsOne!";
    }

    @GetMapping("/sendGreetingsThree")
    public String sendGreetingsThree() {
        return "sendGreetingsTwo! I am the newly added method";
    }

    @GetMapping("/sendGreetingsFour")
    public String sendGreetingsFour() {
        return "sendGreetingsTwo! I am the newly added method";
    }

    @GetMapping("/sendGreetingsFive")
    public String sendGreetingsFive() {
        return "sendGreetingsTwo! I am the newly added method";
    }



}
