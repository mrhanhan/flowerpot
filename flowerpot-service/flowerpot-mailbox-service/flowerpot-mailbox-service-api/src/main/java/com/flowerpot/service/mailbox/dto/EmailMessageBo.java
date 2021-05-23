package com.flowerpot.service.mailbox.dto;

import com.flowerpot.service.mailbox.service.entity.EmailMessage;
import com.flowerpot.service.mailbox.service.entity.EmailMessageContent;
import com.flowerpot.service.mailbox.service.enums.EmailMailboxEnum;
import lombok.Data;

/**
 * EmailMessageBo
 * 邮件消息业务对象
 * @author Mrhan
 * @date 2021/4/7 22:47
 */
@Data
public class EmailMessageBo {
    /**
     * 邮件消息对象
     */
    private EmailMessage message;
    /**
     * 邮件内容对象
     */
    private EmailMessageContent content;
    /**
     * 发送此邮件使用的邮箱
     */
    private EmailMailboxEnum mailbox;
}
