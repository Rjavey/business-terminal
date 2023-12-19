package com.rjavey.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhangrui
 * @create 2023/12/12 16:20
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface SwaggerDisplayEnum {
    String value() default "value";
    String desc() default "desc";
}
