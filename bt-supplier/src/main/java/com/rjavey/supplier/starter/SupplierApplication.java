package com.rjavey.supplier.starter;

import com.rjavey.api.config.DefaultFeignConfig;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author rjavey
 */
@EnableAutoConfiguration
@EnableFeignClients(basePackages = "com.rjavey.api.client",defaultConfiguration = DefaultFeignConfig.class)
@ComponentScan(value = "com.rjavey.supplier")
@MapperScan(value = "com.rjavey.supplier.dao")
@Slf4j
public class SupplierApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupplierApplication.class, args);
        log.info("供应商管理服务启动");
    }
}
