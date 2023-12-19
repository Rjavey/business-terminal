package com.rjavey.common.enums.user;

import com.rjavey.common.annotation.SwaggerDisplayEnum;
import lombok.Getter;

/**
 * @author zhangrui
 * @create 2023/12/19 17:55
 */
@Getter
@SwaggerDisplayEnum(value = "name", desc = "desc")
public enum UserStatus {

    NORMAL("正常"),
    FORBIDDEN("禁用");

    private String desc;

    UserStatus(String desc) {
        this.desc = desc;
    }
}
