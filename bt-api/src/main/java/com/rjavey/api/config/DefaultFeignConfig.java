package com.rjavey.api.config;

import cn.hutool.json.JSONUtil;
import com.rjavey.api.client.fallback.ProductionClientFallbackFactory;
import com.rjavey.api.client.fallback.SupplierClientFallbackFactory;
import com.rjavey.common.enums.Header;
import com.rjavey.common.model.dto.IdentityDTO;
import com.rjavey.common.utils.ThreadIdentityUtil;
import feign.Logger;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Rjavey
 * @create: 2023-12-18 23:37:04
 **/
public class DefaultFeignConfig {

    @Bean
    public ProductionClientFallbackFactory productionClientFallbackFactory(){
        return new ProductionClientFallbackFactory();
    }

    @Bean
    public SupplierClientFallbackFactory supplierClientFallbackFactory(){
        return new SupplierClientFallbackFactory();
    }

    @Bean
    public Logger.Level fullFeignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public RequestInterceptor userInfoRequestInterceptor() {
        return requestTemplate -> {
            IdentityDTO identity = ThreadIdentityUtil.get();
            requestTemplate.header(Header.UserInfo.getCode(), identity != null ? JSONUtil.toJsonStr(identity) : null);
        };
    }
}
