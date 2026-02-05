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

    @GetMapping("/sendGreetingsTwo")
    public String sendGreetingsTwo() {
        return "sendGreetingsTwo!";
    }

    @GetMapping("/sendGreetingsThree")
    public String sendGreetingsTwo() {
        return "sendGreetingsTwo! I am the newly added method";
    }



}
