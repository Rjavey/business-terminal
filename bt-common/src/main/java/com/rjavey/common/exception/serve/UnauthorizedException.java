package com.rjavey.common.exception.serve;

/**
 * 未登录异常
 *
 * @author: Rjavey
 * @create: 2023-12-17 20:46:04
 **/
public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException() {
        super("登录信息未认证");
    }

    public UnauthorizedException(String message) {
        super(message);
    }
}
