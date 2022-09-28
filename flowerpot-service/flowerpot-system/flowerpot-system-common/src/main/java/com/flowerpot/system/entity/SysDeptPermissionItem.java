package com.flowerpot.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.flowerpot.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author Mrhan
 * @date 2021-03-18 22:39
 */
@EqualsAndHashCode(callSuper = true)
@TableName("sys_dept_permission_item")
@Data
public class SysDeptPermissionItem extends BaseEntity implements Serializable {

    /**
     * 部门ID
     */
    @TableField("dept_id")
    private Long deptId;
    /**
     * 不饿
     */
    @TableField("dept_permission_id")
    private Long deptPermissionId;
    /**
     * 关联的记录ID, 根据主表的type 来定义， 可以是部门，角色，用户
     */
    @TableField("relation_id")
    private Long relationId;
}
