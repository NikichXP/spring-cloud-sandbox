package com.arash.edu.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service-b", fallback = DummyControllerFallback.class)
@RequestMapping(method = RequestMethod.GET, value = "/api/v1")
public interface DummyControllerApi {

    @RequestMapping("/methodA")
    String methodA();

    @RequestMapping("/methodB")
    String methodB();

    @RequestMapping("/methodC")
    String methodC();

    @RequestMapping("/methodD")
    String methodD();
}
