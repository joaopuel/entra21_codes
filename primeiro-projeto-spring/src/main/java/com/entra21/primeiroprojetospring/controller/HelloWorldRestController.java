package com.entra21.primeiroprojetospring.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teste")
public class HelloWorldRestController {

    @GetMapping("/")
    public String helloWorld() {
        return "Hello world!";
    }

    @PostMapping("/")
    public String greet(@RequestBody String user) {
        return "Hello, " + user;
    }
}
