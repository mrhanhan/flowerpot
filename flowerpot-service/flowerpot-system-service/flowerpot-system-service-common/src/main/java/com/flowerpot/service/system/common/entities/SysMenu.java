package com.flowerpot.service.system.common.entities;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.flowerpot.common.model.BaseEntity;

import java.io.Serializable;

/**
 * @author Mrhan
 * @date 2021-03-18 22:39
 */
@TableName("sys_menu")
public class SysMenu extends BaseEntity implements Serializable {

    /**
     * 菜单栏CODE 唯一
     */
    private String code;
    /**
     * 0 导航栏 1 菜单栏 2 按钮
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
    /**
     * 是否是有效的记录 1 有效 0 无效
     */
    private Integer effective;
}
