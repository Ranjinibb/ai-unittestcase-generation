package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController1 {

    @GetMapping("/hell")
    public String sendGreetings() {
        return "Hello, World!";
    }

    @GetMapping("/hell1")
    public String sendGreetings1() {
        return "Hello, World!";
    }

    @GetMapping("/hell2")
    public String sendGreetings2() {
        return "Hello, World!";
    }

    @GetMapping("/hell3")
    public String sendGreetings3() {
        return "Hello, World!";
    }

    @GetMapping("/hell4")
    public String sendGreetings4() {
        return "Hello, World!";
    }

    @GetMapping("/hell5")
    public String sendGreetings5() {
        return "Hello, World!";
    }


}
