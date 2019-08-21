package com.arash.edu.service.controllers;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@Log4j2
@RestController
public class HelloController {

    private static final Random RANDOM = new Random();

    @GetMapping("/api/v1/hello")
    public String hello() {
        sleep();
        log.info("Returning hello world message...");
        return "Hello world!";
    }

    private void sleep() {
        int ms = RANDOM.nextInt(2_000);
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            // ignore
        }
    }
}
