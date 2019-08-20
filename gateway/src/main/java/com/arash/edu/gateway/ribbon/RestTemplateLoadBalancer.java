package com.arash.edu.gateway.ribbon;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Component
public class RestTemplateLoadBalancer implements RibbonLoadBalancer {

    private final RestTemplate ribbonRestTemplate;

    @Override
    public <T> T invokeGetMethod(String serviceName, String methodPath, Class<T> responseType) {
        String uri = String.format("http://%s%s", serviceName, methodPath);
        return ribbonRestTemplate.getForObject(uri, responseType);
    }
}
