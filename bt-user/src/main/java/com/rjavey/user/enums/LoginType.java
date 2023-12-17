package com.rjavey.user.enums;

/**
 * @author: Rjavey
 * @create: 2023-12-17 22:48:09
 **/
public enum LoginType {

    Account("account", "账号密码登录"),
    PhoneNumber("phoneNumber", "手机号登录");

    private String code;

    private String desc;

    LoginType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
