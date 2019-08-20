package com.arash.edu.gateway.controllers;

import com.arash.edu.gateway.ribbon.RibbonClientType;
import com.arash.edu.gateway.service.HelloInvoker;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HelloInvokeController {

    private final HelloInvoker helloInvoker;

    @GetMapping("/api/v1/hello/{ribbonClientType}")
    public String invokeHello(@PathVariable RibbonClientType ribbonClientType) {
        return helloInvoker.invokeHello(ribbonClientType);
    }
}
