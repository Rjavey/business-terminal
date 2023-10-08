package com.rjavey.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author rj
 * @create 2023/10/8 13:22
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "bt.snowflake")
public class SnowflakeWorkerConfig {

    private Integer dataId;

    private Integer workerId;
}
