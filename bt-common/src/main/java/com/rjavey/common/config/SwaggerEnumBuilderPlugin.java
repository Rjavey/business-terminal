package com.rjavey.common.config;

import cn.hutool.core.util.ReflectUtil;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.BeanPropertyDefinition;
import com.rjavey.common.annotation.ApiPropertyReference;
import com.rjavey.common.annotation.SwaggerDisplayEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
import springfox.documentation.spi.schema.contexts.ModelPropertyContext;
import springfox.documentation.spi.service.ParameterBuilderPlugin;
import springfox.documentation.spi.service.contexts.ParameterContext;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author zhangrui
 * @create 2023/12/12 16:21
 */
@Component
@Primary
@Slf4j
public class SwaggerEnumBuilderPlugin implements ModelPropertyBuilderPlugin, ParameterBuilderPlugin {
    @Override
    public void apply(ModelPropertyContext modelPropertyContext) {
        // Model中field字段描述的自定义处理策略
        try {

            if (!modelPropertyContext.getBeanPropertyDefinition().isPresent()) {
                return;
            }

            BeanPropertyDefinition beanPropertyDefinition = modelPropertyContext.getBeanPropertyDefinition().get();
            AnnotatedField beanPropertyDefinitionField = beanPropertyDefinition.getField();
            if (beanPropertyDefinitionField == null) {
                return;
            }

            // 没有@ApiModelPropertyReference， 直接返回
            ApiPropertyReference propertyReference =
                    beanPropertyDefinitionField.getAnnotation(ApiPropertyReference.class);
            if (propertyReference == null) {
                return;
            }

            // 生成需要拼接的取值含义描述内容
            String valueDesc = generateValueDesc(propertyReference);
            modelPropertyContext.getBuilder().description(valueDesc)
                    .type(modelPropertyContext.getResolver()
                            .resolve(beanPropertyDefinition.getField().getRawType()));
        } catch (Exception e) {
            log.error("failed to rebuild swagger param description", e);
        }
    }
    @Override
    public void apply(ParameterContext context) {
        // API中入参的自定义处理策略
        ApiPropertyReference reference =
                context.getOperationContext().findAnnotation(ApiPropertyReference.class).orElse(null);
        if (reference == null){
            return;
        }
        String desc = generateValueDesc(reference);
        if (StringUtils.isNotEmpty(reference.name())) {
            context.parameterBuilder().name(reference.name());
        }
        context.parameterBuilder().description(desc);
    }
    @Override
    public boolean supports(DocumentationType delimiter) {
        return true;
    }

    private String generateValueDesc(ApiPropertyReference propertyReference) {
        Class<? extends Enum> rawPrimaryType = propertyReference.referenceClazz();
        SwaggerDisplayEnum swaggerDisplayEnum = AnnotationUtils.findAnnotation(rawPrimaryType,
                SwaggerDisplayEnum.class);
        String enumFullDesc = Arrays.stream(rawPrimaryType.getEnumConstants())
                .filter(Objects::nonNull)
                .map(enumConsts -> {
                    Object fieldValue = ReflectUtil.getFieldValue(enumConsts, swaggerDisplayEnum.value());
                    Object fieldDesc = ReflectUtil.getFieldValue(enumConsts, swaggerDisplayEnum.desc());
                    return fieldValue + ":" + fieldDesc;
                }).collect(Collectors.joining(";"));
        return propertyReference.value() + "(" + enumFullDesc + ")";
    }
}
