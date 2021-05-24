/**
  存储设备表，
  阿里云OSS， 各种云OSS，数据由系统定义，用户只可修改配置
 */
-- drop table if exists `st_store_device`;
create table if not exists `st_store_device`
(
    `id`          bigint(20) primary key comment '存储设备ID',
    `code`        varchar(128) not null comment '配置Code StoreDeviceEnum',
    `name`        varchar(32)  not null comment '设备名称',
    `status`      int          not null comment '设备状态， StoreDeviceStatusEum',
    `supplier`    varchar(32)  not null comment '存储设备供应商类型 StoreDeviceSupplierEnum',
    `config`      text         not null comment '对应配置的JSON或者 Properties',
    `create_time` datetime     not null default current_timestamp comment '创建时间',
    `create_by`   bigint                default 0 comment '创建人',
    `modify_time` datetime              default current_timestamp comment '修改时间',
    `modify_by`   bigint                default 0 comment '修改人',
    `effective`   tinyint      not null default 1 comment '是否是有效的记录 1 有效 0 无效'
) comment '存储设备';

/**
  存储文件
 */
-- drop table if exists `st_store_file`;
create table if not exists `st_store_file`
(
    `id`            bigint(20) primary key comment '存储文件ID',
    `device_id`     bigint(20)   not null comment '存储资源的设备ID',
    `relation_id`   bigint(20)   not null comment '关联的ID',
    `relation_type` int          not null comment '关联的类型 StoreFileRelationTypeEnum',
    `name`          varchar(255) not null comment '文件名称， 不包含后缀名',
    `suffix`        varchar(32)  not null comment '文件后缀名',
    `size`          bigint(20)          not null comment '文件大小',
    `device_path`   varchar(255) not null comment '文件在设备上存储的位置',
    `access_url`    varchar(255) null comment '访问URL',
    `create_time`   datetime     not null default current_timestamp comment '创建时间',
    `create_by`     bigint                default 0 comment '创建人',
    `modify_time`   datetime              default current_timestamp comment '修改时间',
    `modify_by`     bigint                default 0 comment '修改人',
    `effective`     tinyint      not null default 1 comment '是否是有效的记录 1 有效 0 无效'
) comment '存储文件';

/**
  存储文件属性
 */
 -- drop table if exists st_store_file_attribute;
create table if not exists `st_store_file_attribute`
(
    `id`            bigint(20) primary key comment '存储文件ID',
    `file_id`       bigint(20)   not null comment '文件ID',
    `relation_id`   bigint(20)   not null comment '关联的ID 冗余数据',
    `relation_type` int          not null comment '关联的类型 StoreFileRelationTypeEnum 冗余数据',
    `name`          varchar(255) not null comment '属性名称',
    `value`         text         not null comment '属性值',
    `create_time`   datetime     not null default current_timestamp comment '创建时间',
    `create_by`     bigint                default 0 comment '创建人',
    `modify_time`   datetime              default current_timestamp comment '修改时间',
    `modify_by`     bigint                default 0 comment '修改人',
    `effective`     tinyint      not null default 1 comment '是否是有效的记录 1 有效 0 无效'
) comment '存储文件属性';