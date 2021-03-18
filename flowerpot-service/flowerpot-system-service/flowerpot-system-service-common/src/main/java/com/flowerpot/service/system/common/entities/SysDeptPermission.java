package com.flowerpot.service.system.common.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.flowerpot.common.model.BaseEntity;

import java.io.Serializable;

/**
 * @author Mrhan
 * @date 2021-03-18 22:39
 */
@TableName("sys_dept_permission")
public class SysDeptPermission extends BaseEntity implements Serializable {

    /**
     * 部门ID
     */
    @TableField("dept_id")
    private Long deptId;
    /**
     * 部门数据权限类型， 1 可以看全局数据， 2 可以看指定部门或者多个部门数据， 3 可以看指定角色或者多个角色数据, 4 可以看指定用户或者多个用户的的数据
     */
    private Integer type;
    /**
     * 是否是有效的记录 1 有效 0 无效
     */
    private Integer effective;
}
