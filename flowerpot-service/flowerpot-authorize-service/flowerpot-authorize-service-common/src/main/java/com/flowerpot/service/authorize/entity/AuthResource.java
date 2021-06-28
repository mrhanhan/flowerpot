package com.flowerpot.service.authorize.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.flowerpot.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author Mrhan
 * @date 2021-06-07 14:29
 */
@TableName("ac_auth_resource")
@Data
@EqualsAndHashCode(callSuper = true)
public class AuthResource extends BaseEntity implements Serializable{

    /**
     * 受权资源所属组，可空
     */
    @TableField("group_id")
    private Long groupId;
    /**
     * 是否是系统资源
     */
    private Integer system;
    /**
     * 资源名称
     */
    private String name;
    /**
     * 资源编码、权限码
     */
    private String code;
    /**
     * 受权资源类型: 1 URL 2 授权码/按钮
     */
    private Integer type;
    /**
     * 具体受权资源的数据, json
     */
    private String raw;
    /**
     * 资源描述
     */
    @TableField("`desc`")
    private String desc;
}
