package com.rjavey.production.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "test")
@Data
@Component
public class TestConfig {

    private String value;
}
