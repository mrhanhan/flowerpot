package com.flowerpot.service.system.common.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.flowerpot.common.model.BaseEntity;

import java.io.Serializable;

/**
 * @author Mrhan
 * @date 2021-03-18 22:39
 */
@TableName("sys_dept")
public class SysDept extends BaseEntity implements Serializable {

    /**
     * 部门名称
     */
    private String name;
    /**
     * 是否启用此部门 1 启用 0 禁用
     */
    private Integer enable;
    /**
     * 是否是系统默认部门 1 系统默认 0 非系统默认
     */
    private Integer system;
    /**
     * 部门默认的角色
     */
    @TableField("default_role_id")
    private Long defaultRoleId;
    /**
     * 是否是有效的记录 1 有效 0 无效
     */
    private Integer effective;
}
