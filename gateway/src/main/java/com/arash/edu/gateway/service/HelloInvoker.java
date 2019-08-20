package com.arash.edu.gateway.service;

import com.arash.edu.gateway.ribbon.*;
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

    public String invokeHello(RibbonClientType ribbonClientType) {
        RibbonLoadBalancer loadBalancer = pickLoadBalancer(ribbonClientType);
        return loadBalancer.invokeGetMethod(SERVICE_NAME, METHOD_PATH, String.class);
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
