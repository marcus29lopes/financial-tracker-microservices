package com.ftr.transaction.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SecretHeaderInterceptor implements RequestInterceptor {

    @Value("${gateway.secret.header.name}")
    private String headerName;

    @Value("${gateway.secret.header.value}")
    private String headerValue;

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header(headerName, headerValue);
    }
}
