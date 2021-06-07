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
@TableName("ac_role_tree")
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleTree extends BaseEntity implements Serializable{

    /**
     * 关联角色的ID
     */
    @TableField("role_id")
    private Long roleId;
    /**
     * 角色路径 JSON
     */
    private String path;
}
