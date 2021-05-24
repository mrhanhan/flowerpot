package com.flowerpot.common.utils.config;

import com.flowerpot.common.utils.config.annotation.Config;
import com.flowerpot.common.utils.config.model.ConfigField;

import java.lang.annotation.Annotation;

/**
 * ConfigFieldResolve
 * 配置解析
 * @author Mrhan
 * @date 2021/5/24 16:05
 */
public interface ConfigFieldResolve<T extends Annotation> {
    /**
     * 解析配置
     * @param config            配置
     * @param configAnnotation  解析配置
     * @param configField       解析配置
     * @param scope             Scope
     */
    void resolve(Config config, T configAnnotation, ConfigField configField, String scope);
}
