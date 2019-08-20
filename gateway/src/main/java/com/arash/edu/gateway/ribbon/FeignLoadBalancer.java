package com.arash.edu.gateway.ribbon;

import com.arash.edu.gateway.feign.ServiceFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class FeignLoadBalancer implements RibbonLoadBalancer {

    private final ServiceFeignClient serviceFeignClient;

    @Override
    public <T> T invokeGetMethod(String serviceName, String methodPath, Class<T> responseType) {
        return (T) serviceFeignClient.hello();
    }
}
