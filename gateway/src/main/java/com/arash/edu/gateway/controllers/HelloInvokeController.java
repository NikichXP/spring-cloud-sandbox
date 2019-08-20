package com.arash.edu.gateway.controllers;

import com.arash.edu.gateway.enums.EurekaClientType;
import com.arash.edu.gateway.service.impl.EurekaClientHelloInvoker;
import com.arash.edu.gateway.service.impl.FeignHelloInvoker;
import com.arash.edu.gateway.service.HelloInvoker;
import com.arash.edu.gateway.service.impl.RibbonRestTemplateHelloInvoker;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class HelloInvokeController {

    private final EurekaClientHelloInvoker eurekaClientHelloInvoker;
    private final RibbonRestTemplateHelloInvoker ribbonRestTemplateHelloInvoker;
    private final FeignHelloInvoker feignHelloInvoker;

    @GetMapping("/api/v1/hello/{clientType}")
    public String invokeHello(@PathVariable EurekaClientType clientType) {
        val service = pickService(clientType);
        return service.invokeHello();
    }

    private HelloInvoker pickService(EurekaClientType clientType) {
        switch (clientType) {
            case EUREKA_CLIENT: return eurekaClientHelloInvoker;
            case RIBBON_REST_TEMPLATE: return ribbonRestTemplateHelloInvoker;
            case FEIGN: return feignHelloInvoker;
        }
        throw new IllegalStateException("Service not found!");
    }
}
