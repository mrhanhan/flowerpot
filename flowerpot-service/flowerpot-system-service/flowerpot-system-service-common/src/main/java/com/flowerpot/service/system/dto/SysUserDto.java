package com.flowerpot.service.system.dto;

import com.flowerpot.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * SysUserDto
 *
 * @author Mrhan
 * @date 2021/4/2 10:44
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUserDto extends BaseEntity {

    /**
     * 头像
     */
    private String avatar;

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 角色
     */
    private String roleName;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 账号
     */
    private String account;
    /**
     * 邮箱
     */
    private String mailbox;

    /**
     * QQ
     */
    private String qq;

    /**
     * Phone
     */
    private String phone;
}
