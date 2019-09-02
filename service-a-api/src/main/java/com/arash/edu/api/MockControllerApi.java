package com.arash.edu.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "service-a")
@RequestMapping(method = RequestMethod.GET, value = "/api/v1")
public interface MockControllerApi {

    @RequestMapping("/method1")
    String method1();

    @RequestMapping("/method2")
    String method2();

    @RequestMapping("/method3")
    String method3();

    @RequestMapping("/method4")
    String method4();
}
