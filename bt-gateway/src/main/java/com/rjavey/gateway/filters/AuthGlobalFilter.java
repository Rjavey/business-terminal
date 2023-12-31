package com.rjavey.gateway.filters;

import cn.hutool.core.util.StrUtil;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.rjavey.common.enums.Header;
import com.rjavey.common.utils.SnowflakeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHeaders;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@Slf4j
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    private final AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        if (log.isDebugEnabled()) {
            log.debug("Header = {}", exchange.getRequest().getHeaders());
        }

        ServerHttpRequest request = exchange.getRequest();

        // todo url判断

        String token = null;
        List<String> headers = request.getHeaders().get(HttpHeaders.AUTHORIZATION);
        if (!CollectionUtils.isEmpty(headers)) {
            token = headers.get(0);
        }

        if (StrUtil.isBlank(token)) {
            // todo throw exception
        }

        // todo redis check token

        // jwt 解析 todo
        if (!JWTUtil.verify(token, "abck".getBytes())) {
            // todo throw exception
        }
        JWT jwt = JWTUtil.parseToken(token);
        String userInfo = jwt.getPayloads().toString();
        exchange.mutate().request(builder -> {
            builder.header(Header.UserInfo.getCode(), userInfo);
            builder.header(Header.TraceId.getCode(), SnowflakeUtil.getInstance().nextIdStr());
        }).build();

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
