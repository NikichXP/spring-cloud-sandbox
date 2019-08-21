package com.arash.edu.api;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/fallback")
@Component
public class DummyControllerFallback implements DummyControllerApi {

    @Override
    public String methodA() {
        return "service-b-method-a-fallback";
    }

    @Override
    public String methodB() {
        return "service-b-method-b-fallback";
    }

    @Override
    public String methodC() {
        return "service-b-method-c-fallback";
    }

    @Override
    public String methodD() {
        return "service-b-method-d-fallback";
    }
}
