package com.flowerpot.common.utils.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Config
 * 配置注解，此组解用于，组解，表述组解是用于用户输入的
 * @author Mrhan
 * @date 2021/5/24 15:28
 */
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Config {
    /**
     * 标签名称
     * @return  标签名称
     */
    String tag();

}
