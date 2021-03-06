package com.flowerpot.service.mailbox.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.flowerpot.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Mailbox
 *
 * @author Mrhan
 * @date 2021/4/7 21:32
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("mb_email_mailbox")
public class EmailMailbox extends BaseEntity {

    /**
     * 配置Code EmailMailboxEnum
     */
    @TableField("`code`")
    private String code;
    /**
     * 邮箱名称
     */
    @TableField("`name`")
    private String name;
    /**
     * 邮箱账号
     */
    @TableField("`account`")
    private String account;
    /**
     * 邮箱密码
     */
    @TableField("`password`")
    private String password;
    /**
     * 描述信息
     */
    @TableField("`desc`")
    private String desc;
    /**
     * 邮箱服务器机器
     */
    @TableField("mail_host")
    private String mailHost;
    /**
     * 邮件协议
     */
    @TableField("mail_protocol")
    private String mailProtocol;
    /**
     * 邮箱服务器机器端口
     */
    @TableField("mail_port")
    private String mailPort;
    /**
     * 配置信息
     */
    @TableField("mail_config")
    private String mailConfig;
}
