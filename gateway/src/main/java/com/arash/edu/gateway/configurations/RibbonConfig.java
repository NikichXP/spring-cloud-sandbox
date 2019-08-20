package com.arash.edu.gateway.configurations;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RibbonConfig {

    @LoadBalanced
    @Bean
    public RestTemplate ribbonRestTemplate() {
        return new RestTemplate();
    }
}
