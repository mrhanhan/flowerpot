package com.flowerpot.service.system.common.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.flowerpot.common.model.BaseEntity;

import java.io.Serializable;

/**
 * @author Mrhan
 * @date 2021-03-18 22:39
 */
@TableName("sys_user")
public class SysUser extends BaseEntity implements Serializable {

    /**
     * 部门ID
     */
    @TableField("dept_id")
    private Long deptId;
    /**
     * 角色ID
     */
    @TableField("role_id")
    private Long roleId;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 加盐
     */
    private String salt;
    /**
     * 邮箱
     */
    private String mailbox;
    /**
     * 是否是有效的记录 1 有效 0 无效
     */
    private Integer effective;
}
