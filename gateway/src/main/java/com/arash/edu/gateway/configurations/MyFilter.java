package com.arash.edu.gateway.configurations;

import org.apache.catalina.connector.RequestFacade;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Gateway: request on " + ((RequestFacade)servletRequest).getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
