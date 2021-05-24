package com.flowerpot.common.utils.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Mrhan
 * @date 2021/5/24 15:27
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Config(tag = "Radio")
public @interface Radio {
    /**
     * 配置名称
     * @return  配置名称
     */
    String label();

    /**
     * 值
     */
    String value();

    /**
     * 是否是必填
     * @return 是否必填
     */
    boolean required() default false;

}
