package com.arash.edu.gateway.service.impl;

import com.arash.edu.gateway.service.HelloInvoker;
import com.netflix.discovery.EurekaClient;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class EurekaClientHelloInvoker implements HelloInvoker {

    private final EurekaClient eurekaClient;

    @SneakyThrows
    public String invokeHello() {
        val instances = eurekaClient.getApplication("service").getInstances();
        if (instances.isEmpty()) {
            throw new Exception("bad");
        }
        val uri = String.format("%s/api/v1/hello", instances.get(0).getHomePageUrl());
        return new RestTemplate().getForObject(uri, String.class);
    }
}
