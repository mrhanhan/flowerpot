package com.flowerpot.common.utils.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 开关
 * 输入框
 * @author Mrhan
 * @date 2021/5/24 15:27
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Config(tag = "Switch")
public @interface Switch {
    /**
     * 配置名称
     * @return  配置名称
     */
    String label();

    /**
     * 是否是必填
     * @return 是否必填
     */
    boolean required() default false;


}
