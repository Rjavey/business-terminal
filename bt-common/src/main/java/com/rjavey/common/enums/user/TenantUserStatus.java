package com.rjavey.common.enums.user;

import com.rjavey.common.annotation.SwaggerDisplayEnum;
import lombok.Getter;

/**
 * @author zhangrui
 * @create 2023/12/19 18:05
 */
@Getter
@SwaggerDisplayEnum(value = "name", desc = "desc")
public enum TenantUserStatus {

    NORMAL("正常"),
    FORBIDDEN("禁用");

    private String desc;

    TenantUserStatus(String desc) {
        this.desc = desc;
    }
}
