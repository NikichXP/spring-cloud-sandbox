package com.arash.edu.gateway.ribbon;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RequiredArgsConstructor
@Component
public class EurekaClientLoadBalancer implements RibbonLoadBalancer {

    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    private final EurekaClient eurekaClient;

    @Override
    public <T> T invokeGetMethod(String serviceName, String methodPath, Class<T> responseType) {
        List<InstanceInfo> instances = eurekaClient.getApplication(serviceName).getInstances();
        if (instances.isEmpty()) {
            throw new IllegalStateException("No instance of " + " found for serving " + methodPath + " request");
        }
        String uri = String.format("%s%s", instances.get(0).getHomePageUrl(), methodPath);
        return REST_TEMPLATE.getForObject(uri, responseType);
    }
}
