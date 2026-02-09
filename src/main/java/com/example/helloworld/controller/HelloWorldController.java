package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/helloWorld")
    public String helloWorld() {
        return "Hello, World!";
    }

    @GetMapping("/helloWorldOne")
    public String helloWorldOne() {
        return "Hello, World!";
    }

}
