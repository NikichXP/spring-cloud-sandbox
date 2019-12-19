package com.arash.edu.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/test")
public interface SomeSecretController {

    @GetMapping("/secret")
    String secretOps();

}
