package com.arash.edu.gateway.ribbon;

public interface RibbonLoadBalancer {

    <T> T invokeGetMethod(String serviceName, String methodPath, Class<T> responseType);
}
