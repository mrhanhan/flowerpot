/**
  数据库
 */

-- # create database flowerpot char set utf8mb4;
--
use flowerpot;
/* ================================================ 系统邮件模块 ======================================================= */
/**
  邮件消息
 */
-- drop table if exists `mb_email_message`;
create table if not exists `mb_email_message`
(
    `id`          bigint(20) primary key comment '邮件记录ID',
    `mailbox_id`  bigint(20)   not null comment '使用的邮箱ID ',
    `type`        int          not null comment '邮件类型， EmailTypeEnum',
    `buss_type`   int          not null comment '邮件业务， EmailBusinessTypeEnum',
    `buss_id`     bigint(20)   not null comment '邮件业务， 业务ID',
    `title`       varchar(64)  not null comment '邮件标题',
    `sub_title`   varchar(128) not null comment '邮件子标题',
    `targets`     text         not null comment '邮件发送的目标',
    `status`      int          not null comment '邮件消息状态',
    `desc`        varchar(255) not null comment '邮件消息描述',
    `create_time` datetime     not null default current_timestamp comment '创建时间',
    `create_by`   bigint                default 0 comment '创建人',
    `modify_time` datetime              default current_timestamp comment '修改时间',
    `modify_by`   bigint                default 0 comment '修改人',
    `effective`   tinyint      not null default 1 comment '是否是有效的记录 1 有效 0 无效'
) comment '邮件消息表';

/**
  邮件消息内容
 */
-- drop table if exists `mb_email_message_content`;
create table if not exists `mb_email_message_content`
(
    `id`               bigint(20) primary key comment '邮件消息内容ID',
    `email_message_id` bigint(20) not null comment '邮件消息ID',
    `content_type`     int        not null comment '邮件消息内容类型 EmailContentTypeEnum',
    `content`          mediumtext not null comment '邮件内容',
    `create_time`      datetime   not null default current_timestamp comment '创建时间',
    `create_by`        bigint              default 0 comment '创建人',
    `modify_time`      datetime            default current_timestamp comment '修改时间',
    `modify_by`        bigint              default 0 comment '修改人',
    `effective`        tinyint    not null default 1 comment '是否是有效的记录 1 有效 0 无效'
) comment '邮件消息表';

/**
  邮件邮箱, 系统固定的数据，用户只可以修改，不可以增删改
 */
-- drop table if exists `mb_mailbox_setting`;
create table if not exists `mb_email_mailbox`
(
    `id`            bigint(20) primary key comment '邮箱ID',
    `code`          varchar(128) not null comment '配置Code EmailMailboxEnum',
    `name`          varchar(32)  not null comment '邮箱名称',
    `account`       varchar(32)  not null comment '邮箱账号',
    `password`      varchar(255) not null comment '邮箱密码',
    `mail_host`     varchar(255) not null comment '邮箱服务器机器',
    `mail_protocol` varchar(255) not null comment '邮件协议',
    `mail_port`     varchar(6)   not null comment '邮箱服务器机器端口',
    `mail_config`   text         not null comment '配置信息',
    `create_time`   datetime     not null default current_timestamp comment '创建时间',
    `create_by`     bigint                default 0 comment '创建人',
    `modify_time`   datetime              default current_timestamp comment '修改时间',
    `modify_by`     bigint                default 0 comment '修改人',
    `effective`     tinyint      not null default 1 comment '是否是有效的记录 1 有效 0 无效'
) comment '邮件邮箱, 系统固定的数据，用户只可以修改，不可以增删改';