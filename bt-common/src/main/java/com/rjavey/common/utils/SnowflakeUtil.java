package com.rjavey.common.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.rjavey.common.config.SnowflakeWorkerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * 雪花id生成
 * @author zhangrui
 * @create 2023/10/8 13:20
 */
@Component
public class SnowflakeUtil {

    private static SnowflakeWorkerConfig config;

    public static Snowflake getInstance() {
        if (instance == null){
            synchronized (Snowflake.class) {
                if (instance == null){
                    instance = IdUtil.getSnowflake(1, 1);
                }
            }
        }
        return instance;
    }

    private static Snowflake instance = null;

    public static Long nextId() {
        return getInstance().nextId();
    }

    @Autowired
    public void setConfig(SnowflakeWorkerConfig config) {
        SnowflakeUtil.config = config;
    }
}
