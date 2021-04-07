/**
  数据库
 */

-- # create database flowerpot char set utf8mb4;
--
-- use flowerpot;
/* ================================================ 系统部分莫 ======================================================= */
/**
  系统菜单栏
 */
drop table if exists `sys_menu`;
create table `sys_menu`
(
    `id`            bigint(20) primary key comment '菜单栏ID',
    `code`          varchar(32)  not null default '' comment '菜单栏CODE 唯一',
    `type`          tinyint      not null default 1 comment '0 导航栏 1 菜单栏 2 按钮',
    `parent_id`     bigint(20)   not null default 0 comment '上级菜单栏',
    `key`           varchar(32)  not null default '' comment '菜单栏Key, 唯一 主要作为页面跳转的功能',
    `name`          varchar(32)  not null default '' comment '菜单栏名称',
    `icon`          varchar(32)  not null default '' comment '菜单栏图标',
    `enable`        tinyint(1)   not null default 1 comment '是否启用此角色 1 启用 0 禁用',
    `intercept_url` varchar(128) not null default '' comment '拦截的URL 可以是空字符串',
    `sort`          int          not null default 1 comment '排序',
    `create_time`   datetime     not null default current_timestamp comment '创建时间',
    `create_by`     bigint                default 0 comment '创建人',
    `modify_time`   datetime              default current_timestamp comment '修改时间',
    `modify_by`     bigint                default 0 comment '修改人',
    `effective`          tinyint    not null default 1 comment '是否是有效的记录 1 有效 0 无效'
) comment '系统菜单栏表';


/* ================================================= 用户权限部分 ==================================================== */

/**
  系统角色表
 */
drop table if exists `sys_role`;
create table `sys_role`
(
    `id`          bigint(20) primary key comment '角色ID',
    `name`        varchar(128) not null comment '角色名称',
    `enable`      tinyint(1)   not null default 1 comment '是否启用此角色 1 启用 0 禁用',
    `system`      tinyint(1)   not null default 0 comment '是否是系统默认角色 1 系统默认 0 非系统默认',
    `create_time` datetime     not null default current_timestamp comment '创建时间',
    `create_by`   bigint                default 0 comment '创建人',
    `modify_time` datetime              default current_timestamp comment '修改时间',
    `modify_by`   bigint                default 0 comment '修改人',
    `effective`          tinyint    not null default 1 comment '是否是有效的记录 1 有效 0 无效'
) comment '系统角色表';


/**
  系统角色表
 */
drop table if exists `sys_dept`;
create table `sys_dept`
(
    `id`              bigint(20) primary key comment '部门ID',
    `name`            varchar(128) not null comment '部门名称',
    `enable`          tinyint(1)   not null default 1 comment '是否启用此部门 1 启用 0 禁用',
    `system`          tinyint(1)   not null default 0 comment '是否是系统默认部门 1 系统默认 0 非系统默认',
    `default_role_id` bigint(20) comment '部门默认的角色',
    `create_time`     datetime     not null default current_timestamp comment '创建时间',
    `create_by`       bigint                default 0 comment '创建人',
    `modify_time`     datetime              default current_timestamp comment '修改时间',
    `modify_by`       bigint                default 0 comment '修改人',
    `effective`          tinyint    not null default 1 comment '是否是有效的记录 1 有效 0 无效'
) comment '系统部门表';

/**
  部门数据权限表
    关联部门，描述部门可以看到的数据
    新增部门时设置此数据
 */
drop table if exists `sys_dept_permission`;
create table `sys_dept_permission`
(
    `id`          bigint(20) primary key comment '部门ID',
    `dept_id`     bigint(20) not null comment '部门ID',
    `type`        smallint   not null comment '部门数据权限类型， 1 可以看全局数据， 2 可以看指定部门或者多个部门数据， 3 可以看指定角色或者多个角色数据, 4 可以看指定用户或者多个用户的的数据',
    `create_time` datetime   not null default current_timestamp comment '创建时间',
    `create_by`   bigint              default 0 comment '创建人',
    `modify_time` datetime            default current_timestamp comment '修改时间',
    `modify_by`   bigint              default 0 comment '修改人',
    `effective`          tinyint    not null default 1 comment '是否是有效的记录 1 有效 0 无效'
) comment '部门数据权限表';

/**
  部门数据权限表明细表
    是 sys_dept_permission 的子表
    关联部门，描述部门可以看到的数据
    新增部门时设置此数据
 */
drop table if exists `sys_dept_permission_item`;
create table `sys_dept_permission_item`
(
    `id`                 bigint(20) primary key comment '部门ID',
    `dept_id`            bigint(20) not null comment '部门ID',
    `dept_permission_id` bigint(20) not null comment '不饿',
    `relation_id`        bigint(20) not null comment '关联的记录ID, 根据主表的type 来定义， 可以是部门，角色，用户',
    `create_time`        datetime   not null default current_timestamp comment '创建时间',
    `create_by`          bigint              default 0 comment '创建人',
    `modify_time`        datetime            default current_timestamp comment '修改时间',
    `modify_by`          bigint              default 0 comment '修改人',
    `effective`          tinyint    not null default 1 comment '是否是有效的记录 1 有效 0 无效'
) comment '部门数据权限明细表';

/**
  系统用户
 */
drop table if exists `sys_user`;
create table `sys_user`
(
    `id`          bigint(20) primary key comment '用户ID',
    `dept_id`     bigint(20)  not null comment '部门ID',
    `role_id`     bigint(20)  not null comment '角色ID',
    `nickname`    varchar(32) not null comment '昵称',
    `account`     varchar(32) not null comment '账号',
    `password`    varchar(32) not null comment '密码',
    `salt`        varchar(16) not null comment '加盐',
    `mailbox`     varchar(64) not null default '' comment '邮箱',
    `create_time` datetime    not null default current_timestamp comment '创建时间',
    `create_by`   bigint               default 0 comment '创建人',
    `modify_time` datetime             default current_timestamp comment '修改时间',
    `modify_by`   bigint               default 0 comment '修改人',
    `effective`          tinyint    not null default 1 comment '是否是有效的记录 1 有效 0 无效'
) comment '系统用户表';
/**
  用户信息表
 */
drop table if exists `sys_user_info`;
create table `sys_user_info`
(
    `id`          bigint(20) primary key comment 'ID',
    `user_id`     bigint(20)   not null comment '用户ID',
    `avatar`      varchar(128) not null default '' comment '用户头像',
    `qq`          varchar(32)  not null default '' comment 'QQ',
    `phone`       varchar(16)  not null default '' comment '电话',
    `create_time` datetime     not null default current_timestamp comment '创建时间',
    `create_by`   bigint                default 0 comment '创建人',
    `modify_time` datetime              default current_timestamp comment '修改时间',
    `modify_by`   bigint                default 0 comment '修改人',
    `effective`          tinyint    not null default 1 comment '是否是有效的记录 1 有效 0 无效'
) comment '系统用户信息表';
