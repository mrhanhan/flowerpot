/**
  数据库
 */

# create database flowerpot char set utf8mb4;

use flowerpot;

create table if not exists `tp_temp`
(
    `id`          bigint(20) primary key comment 'ID',
    `create_time` datetime not null default current_timestamp comment '创建时间',
    `create_by`   bigint(20)        default 0 comment '创建人',
    `modify_time` datetime          default current_timestamp comment '修改时间',
    `modify_by`   bigint(20)        default 0 comment '修改人',
    `effective`   tinyint  not null default 1 comment '是否是有效的记录 1 有效 0 无效'
) comment '系统用户信息表';

/**
  索引命名规则:
    uni_[表]-[字段]:  唯一索引
    idx_[表]-[字段]:  非唯一索引
    理解组合索引最左前缀原则，避免重复建设索引，如果建立了(a,b,c)，相当于建立了(a), (a,b), (a,b,c)。

 */

/* Drop */

# drop table if exists `sys_role`;
# # system
# drop table if exists `sys_dept`;
# drop table if exists `sys_dept_permission`;
# drop table if exists `sys_dept_permission_item`;
# # user
# drop table if exists `sys_user`;
# drop table if exists `sys_user_info`;
# # storage
# drop table if exists `st_store_device`;
# drop table if exists `st_store_file`;
# drop table if exists `st_store_file_attribute`;
# # mailbox
# drop table if exists `mb_email_message`;
# drop table if exists `mb_email_message_content`;
# drop table if exists `mb_email_mailbox`;
#
# # authorize
# drop table if exists `ac_auth_resource`;
# drop table if exists `ac_auth_resource_rule`;
# drop table if exists `ac_auth_resource_group`;
# drop table if exists `ac_role`;
# drop table if exists `ac_role_tree`;
# drop index `idx_ac_auth_resource_rule-resource_id`;