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

    @GetMapping("/helloWorldTwo")
    public String helloWorldTwo() {
        return "Hello, World!";
    }

    @GetMapping("/helloWorldThree")
    public String helloWorldThree() {
        return "Hello, World!";
    }

    @GetMapping("/helloWorldFour")
    public String helloWorldFour() {
        return "Hello, World!";
    }


}
