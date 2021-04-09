package com.flowerpot.service.mailbox.service;

import com.flowerpot.service.mailbox.dto.EmailMessageBo;

/**
 * MailboxService
 * 邮箱服务, 提供各种邮件的发送服务
 * @author Mrhan
 * @date 2021/4/7 11:26
 */
public interface MailboxService {

    /**
     * 发送邮件
     * @param message   邮件消息
     */
    void sendEmail(EmailMessageBo message);

}
