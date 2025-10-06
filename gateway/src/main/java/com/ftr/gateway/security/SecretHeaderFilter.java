package com.ftr.gateway.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SecretHeaderFilter implements GlobalFilter{


    @Value("${gateway.secret.header.name}")
    private String headerName;

    @Value("${gateway.secret.header.value}")
    private String headerValue;

    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        // cria uma nova requisição com o header adicionado
        var mutatedRequest = exchange.getRequest()
                .mutate()
                .header(headerName, headerValue)
                .build();

        // substitui o request no exchange
        var mutatedExchange = exchange.mutate().request(mutatedRequest).build();

        // segue o fluxo com o novo exchange
        return chain.filter(mutatedExchange);
    }

}
