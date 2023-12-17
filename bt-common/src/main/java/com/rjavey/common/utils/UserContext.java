package com.rjavey.common.utils;

import com.alibaba.ttl.TransmittableThreadLocal;

/**
 * @author: Rjavey
 * @create: 2023-12-17 23:10:05
 **/
public class UserContext {

    private static final TransmittableThreadLocal<Long> uid = new TransmittableThreadLocal<>();

    public static Long getUser() {
        return uid.get();
    }

    public static void setUser(Long userId) {
        uid.set(userId);
    }

    public static void remove() {
        uid.remove();
    }
}
