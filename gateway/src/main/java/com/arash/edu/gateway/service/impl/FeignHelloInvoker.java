package com.arash.edu.gateway.service.impl;

import com.arash.edu.gateway.feign.ServiceFeignClient;
import com.arash.edu.gateway.service.HelloInvoker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FeignHelloInvoker implements HelloInvoker {

    private final ServiceFeignClient serviceFeignClient;

    @Override
    public String invokeHello() {
        return serviceFeignClient.hello();
    }
}
