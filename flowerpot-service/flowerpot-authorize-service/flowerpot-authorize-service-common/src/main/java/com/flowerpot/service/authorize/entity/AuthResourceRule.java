package com.flowerpot.service.authorize.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.flowerpot.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author Mrhan
 * @date 2021-06-07 14:29
 */
@TableName("ac_auth_resource_rule")
@Data
@EqualsAndHashCode(callSuper = true)
public class AuthResourceRule extends BaseEntity implements Serializable{

    /**
     * 受权资源ID
     */
    @TableField("resource_id")
    private Long resourceId;
    /**
     * 规则类型：权限码，角色，等等
     */
    private Integer type;
    /**
     * 表达式
     */
    private String expression;
    /**
     * 规则说明
     */
    @TableField("`desc`")
    private String desc;
}
