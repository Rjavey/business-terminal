package com.rjavey.common.enums;

import lombok.Getter;

/**
 * @author: Rjavey
 * @create: 2023-12-17 22:55:53
 **/
@Getter
public enum Header {

    UserInfo("user-info", "登录后用户信息请求头");

    private String code;
    private String desc;

    Header(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
