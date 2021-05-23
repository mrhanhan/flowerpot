package com.flowerpot.service.mailbox.service.entity;

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
    private String code;
    /**
     * 邮箱名称
     */
    private String name;
    /**
     * 邮箱账号
     */
    private String account;
    /**
     * 邮箱密码
     */
    private String password;
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
    @TableField("mail_protocol")
    private String mailPort;
    /**
     * 配置信息
     */
    @TableField("mail_config")
    private String mailConfig;
}
