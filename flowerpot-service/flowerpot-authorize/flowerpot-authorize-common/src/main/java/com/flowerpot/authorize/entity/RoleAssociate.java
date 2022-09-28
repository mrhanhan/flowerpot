package com.flowerpot.authorize.entity;

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
@TableName("ac_role_associate")
@Data
@EqualsAndHashCode(callSuper = true)
public class RoleAssociate extends BaseEntity implements Serializable{

    /**
     * 关联角色的ID
     */
    @TableField("role_id")
    private Long roleId;
    /**
     * 关系类型 用户、身份 RoleAssociateTypeEnum
     */
    private Integer type;
    /**
     * 关联的目标ID
     */
    @TableField("target_id")
    private Long targetId;
}
