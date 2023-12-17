package com.rjavey.gateway.filters;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

/**
 * @author: Rjavey
 * @create: 2023-12-17 17:31:23
 **/
@Slf4j
@Component
public class PrintLogGatewayFilterFactory extends AbstractGatewayFilterFactory {
    @Override
    public GatewayFilter apply(Object config) {
        return (exchange, chain) -> {
            log.info("Print Log Filter");
            return chain.filter(exchange);
        };
    }
}
