package com.arash.edu.gateway.feign;

import com.arash.edu.api.SomeSecretController;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "service-a")
public interface SecretAppClient extends SomeSecretController {
}
