package com.flowerpot.service.mailbox.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.flowerpot.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * EmailMessageContent
 *
 * @author Mrhan
 * @date 2021/4/7 14:21
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("mb_email_message_content")
public class EmailMessageContent extends BaseEntity {

    /**
     * 邮件消息ID
     */
    @TableField("email_message_id")
    private Long emailMessageId;

    /**
     * 邮件内容类型
     */
    @TableField("content_type")
    private Integer contentType;

    /**
     * 邮件内容
     */
    private String content;
}
