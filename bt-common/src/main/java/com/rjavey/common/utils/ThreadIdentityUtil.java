package com.rjavey.common.utils;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.rjavey.common.model.dto.IdentityDTO;

/**
 * 线程用户身份工具
 *
 * @author rjavey
 */
public class ThreadIdentityUtil {

    private static ThreadLocal<IdentityDTO> threadLocal = new TransmittableThreadLocal<>();


    public static void set(IdentityDTO dto) {
        threadLocal.set(dto);
    }

    public static IdentityDTO get() {
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }


}