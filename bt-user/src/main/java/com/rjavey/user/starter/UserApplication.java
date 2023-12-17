package com.rjavey.user.starter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author: Rjavey
 * @create: 2023-12-17 20:34:47
 **/
@SpringCloudApplication
@EnableAutoConfiguration
@Slf4j
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
        log.info("gateway服务启动");
    }
}
