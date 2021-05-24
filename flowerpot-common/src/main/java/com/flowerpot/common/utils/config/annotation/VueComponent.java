package com.flowerpot.common.utils.config.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * VueComponent
 *
 * @author Mrhan
 * @date 2021/5/24 15:50
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Config(tag = "")
public @interface VueComponent {
    /**
     * Vue 自定义组件
     * @return  vue 自定义组件
     */
    String tag();
    /**
     * 标签名称
     * @return  标签名称
     */
    String label();

    /**
     * 是否是必填
     * @return  是否是必填
     */
    boolean required();
}
