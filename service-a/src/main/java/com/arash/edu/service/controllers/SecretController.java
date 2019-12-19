package com.arash.edu.service.controllers;

import com.arash.edu.api.SomeSecretController;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecretController implements SomeSecretController {

    @Override
    public String secretOps() {
        return "Rocket launched! We're doomed.";
    }
}
