package com.arash.edu.gateway.service;

import com.arash.edu.gateway.ribbon.*;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class HelloInvoker {

    private static final String SERVICE_NAME = "service";
    private static final String METHOD_PATH = "/api/v1/hello";

    private final EurekaClientLoadBalancer eurekaClientLoadBalancer;
    private final RestTemplateLoadBalancer restTemplateLoadBalancer;
    private final FeignLoadBalancer feignLoadBalancer;

    @HystrixCommand(fallbackMethod = "invokeHelloFallback",
    threadPoolKey = "helloServiceThreadPool",
    threadPoolProperties = {
            @HystrixProperty(name = "coreSize", value = "30"),
            @HystrixProperty(name = "maxQueueSize", value = "10")
    },
    commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public String invokeHello(RibbonClientType ribbonClientType) {
        RibbonLoadBalancer loadBalancer = pickLoadBalancer(ribbonClientType);
        return loadBalancer.invokeGetMethod(SERVICE_NAME, METHOD_PATH, String.class);
    }

    public String invokeHelloFallback(RibbonClientType ribbonClientType) {
        return "This is a fallback message, sorry. Anyway, it is better than exception.";
    }

    private RibbonLoadBalancer pickLoadBalancer(RibbonClientType ribbonClientType) {
        switch (ribbonClientType) {
            case EUREKA_CLIENT: return eurekaClientLoadBalancer;
            case RIBBON_REST_TEMPLATE: return restTemplateLoadBalancer;
            case FEIGN: return feignLoadBalancer;
        }
        throw new IllegalStateException("Unable to pick the client load balancer for " + ribbonClientType);
    }
}
