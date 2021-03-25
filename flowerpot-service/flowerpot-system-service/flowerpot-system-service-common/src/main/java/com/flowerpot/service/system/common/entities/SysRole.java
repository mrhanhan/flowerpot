package com.flowerpot.service.system.common.entities;

import com.baomidou.mybatisplus.annotation.TableName;
import com.flowerpot.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author Mrhan
 * @date 2021-03-18 22:39
 */
@TableName("sys_role")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRole extends BaseEntity implements Serializable {

    /**
     * 角色名称
     */
    private String name;
    /**
     * 是否启用此角色 1 启用 0 禁用
     */
    private Integer enable;
    /**
     * 是否是系统默认角色 1 系统默认 0 非系统默认
     */
    private Integer system;
}
