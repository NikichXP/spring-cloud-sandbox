package com.arash.edu.serviceb.controllers;

import com.arash.edu.api.DummyControllerApi;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController implements DummyControllerApi {

    @Override
    public String methodA() {
        return "Method A response text";
    }

    @Override
    public String methodB() {
        return "Method B response text";
    }

    @Override
    public String methodC() {
        return "Method C response text";
    }

    @Override
    public String methodD() {
        return "Method Dloca response text";
    }
}
