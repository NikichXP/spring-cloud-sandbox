package com.arash.edu.dummyapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class DummyAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(DummyAppApplication.class, args);
    }

}
