package com.rjavey.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhangrui
 * @create 2023/12/12 16:19
 */
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiPropertyReference {
    // 接口文档上的显示的字段名称，不设置则使用field本来名称
    String name() default "";
    // 字段简要描述，可选
    String value() default "";
    // 标识字段是否必填
    boolean required() default  false;
    // 指定取值对应的枚举类
    Class<? extends Enum> referenceClazz();
}
