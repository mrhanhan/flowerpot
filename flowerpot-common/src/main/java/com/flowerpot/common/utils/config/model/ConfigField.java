package com.flowerpot.common.utils.config.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * ConfigField
 *
 * @author Mrhan
 * @date 2021/5/24 15:53
 */
@Data
public class ConfigField {
    /**
     * 字段
     */
    private String field;

    /**
     * Label
     */
    private String label;
    /**
     * 字段作用域
     */
    private String scope;
    /**
     * 字段标签
     */
    private String tag;
    /**
     * 字段属性配置
     */
    private Map<String, Object> attrMap;
    /**
     * 字字段
     */
    private List<ConfigField> children;

}
