package com.flowerpot.common.utils.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Input
 * 输入框
 * @author Mrhan
 * @date 2021/5/24 15:27
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Config(tag = "Input")
public @interface Input {
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

    /**
     *  数据类型
     * @return  数据类型
     */
    String type() default "text";

    /**
     * 最大长度
     * @return      最大长度
     */
    int maxLength() default -1;

    /**
     * 最小长度
     * @return      最小长度
     */
    int minLength() default -1;

    /**
     * 正则表达式
     * @return  规定数据格式
     */
    String pattern() default "";

    /**
     * placeholder
     */
    String placeholder() default "";
}
