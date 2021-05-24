package com.flowerpot.common.utils.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Table
 *
 * @author Mrhan
 * @date 2021/5/24 15:52
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Config(tag = "Table")
public @interface Table {
    /**
     * 表格的标题
     * @return  标题
     */
    String label();

    /**
     * 是否是必填
     */
    boolean required() default false;
}
