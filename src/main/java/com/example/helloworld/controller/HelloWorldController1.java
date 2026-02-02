package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController1 {

    @GetMapping("/hello")
    public String sendGreetings() {
        return "Hello, World!";
    }

    @GetMapping("/hello1")
    public String sendGreetings1() {
        return "Hello, World!";
    }

    @GetMapping("/hello2")
    public String sendGreetings2() {
        return "Hello, World!";
    }


}
