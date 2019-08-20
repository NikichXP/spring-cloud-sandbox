package com.arash.edu.gateway.service.impl;

import com.arash.edu.gateway.service.HelloInvoker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class RibbonRestTemplateHelloInvoker implements HelloInvoker {

    private final RestTemplate ribbonRestTemplate;

    @Override
    public String invokeHello() {
        String uri = String.format("http://%s/api/v1/hello", "service");
        return ribbonRestTemplate.getForObject(uri, String.class);
    }
}
