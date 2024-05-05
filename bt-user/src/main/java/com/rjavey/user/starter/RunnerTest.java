package com.rjavey.user.starter;

import jakarta.annotation.Resource;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @author: Rjavey
 * @create: 2024-05-05 18:54:54
 **/
@Component
public class RunnerTest implements ApplicationRunner {

    @Resource
    public RocketMQTemplate rocketMQTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        while (true) {
            rocketMQTemplate.syncSend("springboot-mq:001001", "SimpleMsg:" + UUID.randomUUID());
            Thread.sleep(1000);
        }
    }
}
