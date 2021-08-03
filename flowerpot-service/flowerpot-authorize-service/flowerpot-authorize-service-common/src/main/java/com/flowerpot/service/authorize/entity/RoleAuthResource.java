package com.flowerpot.service.authorize.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.flowerpot.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author Mrhan
 * @date 2021-08-03 23:44
 */
@TableName("ac_role_auth_resource")
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleAuthResource extends BaseEntity implements Serializable{

    /**
     * 关联角色的ID
     */
    @TableField("role_id")
    private Long roleId;
    /**
     * 资源ID
     */
    @TableField("auth_id")
    private Long authId;
    /**
     * 资源编码 冗余
     */
    @TableField("auth_code")
    private String authCode;
}
