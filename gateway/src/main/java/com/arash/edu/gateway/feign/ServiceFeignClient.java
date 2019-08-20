package com.arash.edu.gateway.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("service")
public interface ServiceFeignClient {

    @GetMapping("/api/v1/hello")
    String hello();
}
