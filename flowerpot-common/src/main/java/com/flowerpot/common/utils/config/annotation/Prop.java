package com.flowerpot.common.utils.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Attr
 *
 * @author Mrhan
 * @date 2021/5/24 16:57
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Prop {
    /**
     * 配置名称
     */
    String name();

    /**
     * 值
     * @return
     */
    String value();
}
