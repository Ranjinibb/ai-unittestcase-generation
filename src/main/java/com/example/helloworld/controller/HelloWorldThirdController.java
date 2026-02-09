package com.example.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldThirdController {

    @GetMapping("/thirdCtrl")
    public String sendGreetings() {
        return "sendGreetings!";
    }

    @GetMapping("/thirdCtrlOne")
    public String sendGreetingsOne() {
        return "sendGreetingsOne!";
    }

    @GetMapping("/thirdCtrlTwo")
    public String sendGreetingsTwo() {
        return "sendGreetingsOne!";
    }

}
