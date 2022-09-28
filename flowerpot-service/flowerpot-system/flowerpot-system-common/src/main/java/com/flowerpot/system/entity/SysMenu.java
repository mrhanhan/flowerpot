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
@TableName("sys_menu")
@Data
@EqualsAndHashCode(callSuper = true)
public class SysMenu extends BaseEntity implements Serializable {

    /**
     * 菜单栏CODE 唯一
     */
    private String code;
    /**
     * 0 导航栏 1 菜单栏 2 权限
     */
    private Integer type;
    /**
     * 上级菜单栏
     */
    @TableField("parent_id")
    private Long parentId;
    /**
     * 菜单栏Key, 唯一 主要作为页面跳转的功能
     */
    private String key;
    /**
     * 菜单栏名称
     */
    private String name;
    /**
     * 菜单栏图标
     */
    private String icon;
    /**
     * 是否启用此角色 1 启用 0 禁用
     */
    private Integer enable;
    /**
     * 拦截的URL 可以是空字符串
     */
    @TableField("intercept_url")
    private String interceptUrl;
    /**
     * 排序
     */
    private Integer sort;
}
