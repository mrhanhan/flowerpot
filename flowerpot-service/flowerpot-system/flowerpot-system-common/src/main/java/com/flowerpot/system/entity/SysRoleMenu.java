package com.flowerpot.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.flowerpot.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author Mrhan
 * @date 2022/5/4 16:40
 */
@TableName("sys_role_menu")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRoleMenu extends BaseEntity implements Serializable {
    /**
     * 菜单栏ID
     */
    private Long menuId;

    /**
     * 角色ID
     */
    private Long roleId;
}
