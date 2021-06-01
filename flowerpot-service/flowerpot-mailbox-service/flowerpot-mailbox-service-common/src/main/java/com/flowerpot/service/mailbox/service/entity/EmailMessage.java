package com.flowerpot.service.mailbox.service.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.flowerpot.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * EmailMessage
 * 邮件消息
 * @author Mrhan
 * @date 2021/4/7 11:40
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("mb_email_message")
public class EmailMessage extends BaseEntity {

    /**
     * 发送邮件使用邮箱的ID
     */
    @TableField("mailbox_id")
    private Long mailboxId;
    /**
     * 邮箱类型
     */
    private Integer type;
    /**
     * 业务类型
     */
    @TableField("buss_type")
    private Integer bussType;
    /**
     * 业务ID
     */
    @TableField("buss_id")
    private Long bussId;
    /**
     * 邮件标题
     */
    private String title;
    /**
     * 邮件子标题
     */
    @TableField("sub_tile")
    private String subTitle;
    /**
     * 发送目标
     */
    private String targets;
    /**
     * 发送状态
     */
    private Integer status;
    /**
     * 邮件 说明
     */
    private String desc;
}
