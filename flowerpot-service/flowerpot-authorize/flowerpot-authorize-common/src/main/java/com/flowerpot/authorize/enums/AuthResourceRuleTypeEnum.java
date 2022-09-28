package com.flowerpot.authorize.enums;

import com.flowerpot.common.KeyDescProvider;
import lombok.RequiredArgsConstructor;

/**
 * AuthResourceRuleTypeEnum
 *
 * 授权资源分组表达式实现：
 *      在所有分组成员中，头需要添加分组分组ID
 *
 * @author Mrhan
 * @date 2021/7/17 18:29
 */
@RequiredArgsConstructor
public enum AuthResourceRuleTypeEnum implements KeyDescProvider {

    /**
     * and 分组
     */
    AND_GROUPING(101, "AND 分组"),
    /**
     * or 分组
     */
    OR_GROUPING(102, "OR 分组"),

    /**
     * 需要授权
     */
    NEED_CERTIFICATION(201, "需要登录"),

    /**
     * 需要权限
     */
    NEED_PERMISSION(301, "需要权限"),
    /**
     * 需要角色
     */
    NEED_ROLE(302, "需要角色"),
    /**
     * 指定IP
     */
    SPECIFY_IP(401, "指定IP"),
    ;
    private final int key;
    private final String desc;

    @Override
    public Integer getKey() {
        return key;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
