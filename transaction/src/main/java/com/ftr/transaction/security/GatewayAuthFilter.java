package com.ftr.transaction.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class GatewayAuthFilter extends OncePerRequestFilter {

    @Value("${gateway.secret.header.name}")
    private String headerName;

    @Value("${gateway.secret.header.value}")
    private String headerValue;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader(headerName);

        if (header == null || !header.equals(headerValue)) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.getWriter().write("Access denied: request not from Gateway");
            return;
        }

        filterChain.doFilter(request, response);
    }
}