package com.arash.edu.service.controllers;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
public class HelloController {

    @GetMapping("/api/v1/hello")
    public String hello() {
        log.info("Returning hello world message...");
        return "Hello world!";
    }
}
