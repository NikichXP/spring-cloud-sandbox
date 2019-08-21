package com.arash.edu.gateway.service;

import com.arash.edu.api.DummyControllerApi;
import com.arash.edu.api.MockControllerApi;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.function.Supplier;

@RequiredArgsConstructor
@Service
public class DummyService {

    private static final Random RANDOM = new Random();

    private final MockControllerApi mockProxy;
    private final DummyControllerApi dummyProxy;

    public String callServices() {
        StringBuilder sb = new StringBuilder();
        call(mockProxy::method1, sb);
        call(dummyProxy::methodB, sb);
        call(mockProxy::method2, sb);
        call(dummyProxy::methodB, sb);
        call(mockProxy::method3, sb);
        call(dummyProxy::methodC, sb);
        call(mockProxy::method4, sb);
        call(dummyProxy::methodD, sb);
        return sb.toString();
    }

    private void call(Supplier<String> method, StringBuilder sb) {
        if (coinFlip()) {
            String methodResponse = method.get();
            sb.append("\n").append(methodResponse);
        }
    }

    private boolean coinFlip() {
        return RANDOM.nextInt(2) == 0;
    }
}
