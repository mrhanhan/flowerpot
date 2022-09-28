package com.flowerpot.authorize.entity;

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
@TableName("ac_role")
@Data
@EqualsAndHashCode(callSuper = true)
public class Role extends BaseEntity implements Serializable{

    /**
     * 上级角色ID
     */
    @TableField("parent_id")
    private Long parentId;
    /**
     * 角色层级
     */
    private Integer level;
    /**
     * 角色名称
     */
    private String name;
    /**
     * 角色名称
     */
    @TableField("`desc`")
    private String desc;
}
