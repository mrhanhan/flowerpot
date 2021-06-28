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
@TableName("ac_auth_resource_group")
@Data
@EqualsAndHashCode(callSuper = true)
public class AuthResourceGroup extends BaseEntity implements Serializable{

    /**
     * 资源组名称
     */
    private String name;
    /**
     * 是否是系统资源组 1 是， 0 否
     */
    private Integer system;
    /**
     * 资源组描述
     */
    @TableField("`desc`")
    private String desc;
}
