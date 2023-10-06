package com.rjavey.production.starter;

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
@EnableFeignClients
@ComponentScan(value = "com.rjavey.production")
@MapperScan(value = "com.rjavey.production.dao")
public class ProductionApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductionApplication.class,args);
//        log.info("生产管理服务启动");
    }
}
