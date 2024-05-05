package com.rjavey.user.starter;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: Rjavey
 * @create: 2023-12-17 20:34:47
 **/
@EnableAutoConfiguration
@ComponentScan(value = "com.rjavey.user")
@MapperScan(value = "com.rjavey.user.dao")
@Slf4j
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
        log.info("User服务启动");
    }
}
