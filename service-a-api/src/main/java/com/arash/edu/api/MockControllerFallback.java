package com.arash.edu.api;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/fallback")
@Component
public class MockControllerFallback implements MockControllerApi {

    @Override
    public String method1() {
        return "service-a-method-1-fallback";
    }

    @Override
    public String method2() {
        return "service-a-method-2-fallback";
    }

    @Override
    public String method3() {
        return "service-a-method-3-fallback";
    }

    @Override
    public String method4() {
        return "service-a-method-4-fallback";
    }
}
