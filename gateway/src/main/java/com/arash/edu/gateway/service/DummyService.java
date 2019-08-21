package com.arash.edu.gateway.service;

import com.arash.edu.api.DummyControllerApi;
import com.arash.edu.api.MockControllerApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@RequiredArgsConstructor
@Service
public class DummyService {

    private static final Random RANDOM = new Random();

    private final MockControllerApi mockProxy;
    private final DummyControllerApi dummyProxy;

    public String callServices() {
        StringBuilder sb = new StringBuilder();
        if (coinFlip()) {
            sb.append(mockProxy.method1()).append("\n");
        }
        if (coinFlip()) {
            sb.append(dummyProxy.methodA()).append("\n");
        }
        if (coinFlip()) {
            sb.append(mockProxy.method2()).append("\n");
        }
        if (coinFlip()) {
            sb.append(dummyProxy.methodB()).append("\n");
        }
        if (coinFlip()) {
            sb.append(mockProxy.method3()).append("\n");
        }
        if (coinFlip()) {
            sb.append(dummyProxy.methodC()).append("\n");
        }
        if (coinFlip()) {
            sb.append(mockProxy.method4()).append("\n");
        }
        if (coinFlip()) {
            sb.append(dummyProxy.methodD()).append("\n");
        }
        return sb.toString();
    }

    private boolean coinFlip() {
        return RANDOM.nextInt(2) == 0;
    }
}
