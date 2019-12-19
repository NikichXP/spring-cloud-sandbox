package com.arash.edu.gateway.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/foo")
public class NewController {

    @GetMapping("/a")
    public String a() {
        System.out.println("hello called");
        return "hello";
    }

}
