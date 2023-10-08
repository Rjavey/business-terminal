package com.rjavey.common.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.rjavey.common.config.SnowflakeWorkerConfig;

import javax.annotation.Resource;

/**
 * 雪花id生成
 * @author zhangrui
 * @create 2023/10/8 13:20
 */
public class SnowflakeUtil {

    private static SnowflakeWorkerConfig config;

    @Resource
    public void setConfig(SnowflakeWorkerConfig config) {
        SnowflakeUtil.config = config;
    }

    private static Snowflake instance = null;

    public static Snowflake getInstance() {
        if (instance == null){
            synchronized (instance){
                if (instance == null){
                    instance = IdUtil.getSnowflake(config.getWorkerId(),config.getDataId());
                }
            }
        }
        return instance;
    }
}
