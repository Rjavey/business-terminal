package com.rjavey.production.starter;

import com.rjavey.api.config.DefaultFeignConfig;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author rjavey
 */
@SpringCloudApplication
@EnableAutoConfiguration
@EnableFeignClients(basePackages = "com.rjavey.api.client",defaultConfiguration = DefaultFeignConfig.class)
@ComponentScan(value = "com.rjavey.production")
@MapperScan(value = "com.rjavey.production.dao")
@Slf4j
public class ProductionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductionApplication.class,args);
        log.info("产品管理服务启动");
    }
}
