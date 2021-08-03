/**
  数据库
 */

-- # create database flowerpot char set utf8mb4;
--
-- use flowerpot;

/* ========================== 授权模块 ============================== */
/*
  权限模块包含如下内容:
    资源组
    资源:
    权限
    角色
    角色组
    角色区

    角色对应关系

 */

/**
  受权资源组表
  对资源的分组
 */
-- drop table if exists `ac_auth_resource_group`;
create table if not exists `ac_auth_resource_group`
(
    `id`          bigint(20) primary key comment 'ID',
    `name`        varchar(32) not null comment '资源组名称',
    `system`      tinyint     not null comment '是否是系统资源组 1 是， 0 否',
    `desc`        varchar(255) comment '资源组描述',
    `create_time` datetime    not null default current_timestamp comment '创建时间',
    `create_by`   bigint(20)           default 0 comment '创建人',
    `modify_time` datetime             default current_timestamp comment '修改时间',
    `modify_by`   bigint(20)           default 0 comment '修改人',
    `effective`   tinyint     not null default 1 comment '是否是有效的记录 1 有效 0 无效'
) comment '受权资源组表';

/**
  受权资源表
  资源类型： url, code,
 */
-- drop table if exists `ac_auth_resource`;
create table if not exists `ac_auth_resource`
(
    `id`          bigint(20) primary key comment 'ID',
    `group_id`    bigint(20) comment '受权资源所属组，可空',
    `system`      tinyint     not null comment '是否是系统资源',
    `name`        varchar(64) not null comment '资源名称',
    `code`        varchar(64) not null comment '资源编码、权限码',
    `type`        int         not null comment '受权资源类型: 1 URL 2 授权码/按钮',
    `raw`         text        not null comment '具体受权资源的数据',
    `desc`        varchar(255) comment '资源描述',
    `create_time` datetime    not null default current_timestamp comment '创建时间',
    `create_by`   bigint(20)           default 0 comment '创建人',
    `modify_time` datetime             default current_timestamp comment '修改时间',
    `modify_by`   bigint(20)           default 0 comment '修改人',
    `effective`   tinyint     not null default 1 comment '是否是有效的记录 1 有效 0 无效'
) comment '受权资源表';

/**
  用于拦截URL资源或者其他资源的拦截规则表
  和 ac_auth_resource 是多对一关系
 */

create table if not exists `ac_auth_resource_rule`
(
    `id`          bigint(20) primary key comment 'ID',
    `resource_id` bigint(20)   not null comment '受权资源ID',
    `type`        int          not null comment '规则类型：权限码，角色，等等',
    `expression`  varchar(512) not null comment '表达式，可以是权限码',
    `desc`        varchar(255)          default '' comment '描述',
    `create_time` datetime     not null default current_timestamp comment '创建时间',
    `create_by`   bigint(20)            default 0 comment '创建人',
    `modify_time` datetime              default current_timestamp comment '修改时间',
    `modify_by`   bigint(20)            default 0 comment '修改人',
    `effective`   tinyint      not null default 1 comment '是否是有效的记录 1 有效 0 无效'
) comment '受权规则表';
/**
  角色
  树形，角色可继承
 */
-- drop table if exists `ac_role`;
create table if not exists `ac_role`
(
    `id`          bigint(20) primary key comment 'ID',
    `parent_id`   bigint(20) comment '上级角色ID',
    `level`       int          not null comment '角色层级',
    `name`        varchar(64)  not null comment '角色名称',
    `desc`        varchar(255) not null comment '角色名称',
    `create_time` datetime     not null default current_timestamp comment '创建时间',
    `create_by`   bigint(20)            default 0 comment '创建人',
    `modify_time` datetime              default current_timestamp comment '修改时间',
    `modify_by`   bigint(20)            default 0 comment '修改人',
    `effective`   tinyint      not null default 1 comment '是否是有效的记录 1 有效 0 无效'
);
/**
  角色树形
 */
-- drop table if exists `ac_role_tree`;
create table if not exists `ac_role_tree`
(
    `id`          bigint(20) primary key comment 'ID',
    `role_id`     bigint(20) not null comment '关联角色的ID',
    `path`        text       not null comment '角色路径 JSON',
    `create_time` datetime   not null default current_timestamp comment '创建时间',
    `create_by`   bigint(20)          default 0 comment '创建人',
    `modify_time` datetime            default current_timestamp comment '修改时间',
    `modify_by`   bigint(20)          default 0 comment '修改人',
    `effective`   tinyint    not null default 1 comment '是否是有效的记录 1 有效 0 无效'
) comment '角色树形表';
/**
  角色和权限的关系
 */
-- drop table if exists `ac_role_auth_resource`;
create table if not exists `ac_role_auth_resource`
(
    `id`          bigint(20) primary key comment 'ID',
    `role_id`     bigint(20)  not null comment '关联角色的ID',
    `auth_id`     bigint(20)  not null comment '资源ID',
    `auth_code`   varchar(32) not null comment '资源编码',
    `create_time` datetime    not null default current_timestamp comment '创建时间',
    `create_by`   bigint(20)           default 0 comment '创建人',
    `modify_time` datetime             default current_timestamp comment '修改时间',
    `modify_by`   bigint(20)           default 0 comment '修改人',
    `effective`   tinyint     not null default 1 comment '是否是有效的记录 1 有效 0 无效'
) comment '角色权限表';
/**
  角色关联表
  用户、身份、关联角色的关系表
 */
-- drop table if exists `ac_role_associate`
create table if not exists `ac_role_associate`
(
    `id`          bigint(20) primary key comment 'ID',
    `role_id`     bigint(20) not null comment '关联角色的ID',
    `type`        int        not null comment '关系类型 用户、身份 RoleAssociateTypeEnum',
    `target_id`   bigint(20) not null comment '关联的目标ID',
    `create_time` datetime   not null default current_timestamp comment '创建时间',
    `create_by`   bigint(20)          default 0 comment '创建人',
    `modify_time` datetime            default current_timestamp comment '修改时间',
    `modify_by`   bigint(20)          default 0 comment '修改人',
    `effective`   tinyint    not null default 1 comment '是否是有效的记录 1 有效 0 无效'
) comment '角色权限表';
/**
  身份表
  用户可以拥有多个身份
  待定
 */


/*=========================================== 索引 ======================================*/

# drop index `idx_ac_auth_resource_rule-resource_id`;
# create index  `idx_ac_auth_resource_rule-resource_id` on `ac_auth_resource_rule`(resource_id);
