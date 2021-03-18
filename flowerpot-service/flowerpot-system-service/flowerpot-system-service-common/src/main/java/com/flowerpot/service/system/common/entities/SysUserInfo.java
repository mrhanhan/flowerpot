package com.flowerpot.service.system.common.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.flowerpot.common.model.BaseEntity;

import java.io.Serializable;

/**
 * @author Mrhan
 * @date 2021-03-18 22:39
 */
@TableName("sys_user_info")
public class SysUserInfo extends BaseEntity implements Serializable {

    /**
     * 用户ID
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 用户头像
     */
    private String avatar;
    /**
     * QQ
     */
    private String qq;
    /**
     * 电话
     */
    private String phone;
    /**
     * 是否是有效的记录 1 有效 0 无效
     */
    private Integer effective;
}
