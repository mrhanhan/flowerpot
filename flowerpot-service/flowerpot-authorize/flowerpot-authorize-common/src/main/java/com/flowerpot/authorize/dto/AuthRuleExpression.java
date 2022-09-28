package com.flowerpot.authorize.dto;

import lombok.Data;

/**
 * AuthRuleExpression
 * 授权规则表达式对象
 * @author Mrhan
 * @date 2021/7/17 18:38
 */
@Data
public class AuthRuleExpression {

    /**
     * 同资源下表达式ID
     */
    private int id;
    /**
     * 分组层级
     */
    private int groupLevel;
    /**
     * 分组路径
     */
    private String groupPath;
    /**
     * 表达式值
     */
    private String value;

}
