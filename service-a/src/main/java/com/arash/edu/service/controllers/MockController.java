package com.arash.edu.service.controllers;

import com.arash.edu.api.MockControllerApi;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class MockController implements MockControllerApi {

    private static final Random RANDOM = new Random();

    @Override
    public String method1() {
        randomDelay();
        return "service-a-method-1";
    }

    @Override
    public String method2() {
        randomDelay();
        return "service-a-method-2";
    }

    @Override
    public String method3() {
        randomDelay();
        return "service-a-method-3";
    }

    @Override
    public String method4() {
        randomDelay();
        return "service-a-method-4";
    }

    private static void randomDelay() {
        long sleepMillis = RANDOM.nextInt(2_000);
        try {
            Thread.sleep(sleepMillis);
        } catch (InterruptedException e) {
            // ignore yet
        }
    }
}
