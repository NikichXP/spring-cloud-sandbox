package com.arash.edu.dummyapp.scheduled;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Log4j2
@Component
public class DummyGatewaySpammer {

    private static final String GATEWAY_IP = "http://localhost:8001";
    private static final String DUMMY_PATH = "/api/v1/dummy";

    private final RestTemplate restTemplate = new RestTemplate();

    @Scheduled(fixedRate = 3_000)
    public void dummySpam() {
        String dummyResponse = restTemplate.getForObject(GATEWAY_IP.concat(DUMMY_PATH), String.class);
        log.info(dummyResponse);
    }
}
