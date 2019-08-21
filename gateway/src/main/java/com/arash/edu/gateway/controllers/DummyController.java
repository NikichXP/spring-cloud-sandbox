package com.arash.edu.gateway.controllers;

import com.arash.edu.gateway.service.DummyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping(method = RequestMethod.GET, value = "/api/v1")
@RestController
public class DummyController {

    private final DummyService dummyService;

    @RequestMapping("/dummy")
    public String callDummy() {
        return dummyService.callServices();
    }
}
