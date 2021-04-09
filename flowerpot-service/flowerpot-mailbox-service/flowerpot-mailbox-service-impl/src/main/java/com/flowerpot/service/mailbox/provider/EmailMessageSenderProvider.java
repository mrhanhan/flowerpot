package com.flowerpot.service.mailbox.provider;

import com.flowerpot.service.mailbox.service.entity.EmailMailbox;
import org.springframework.mail.MailSender;

/**
 * EmailMessageSenderProvider
 * 电子邮件发送服务提供者
 * @author Mrhan
 * @date 2021/4/9 9:11
 */
public interface EmailMessageSenderProvider {

    /**
     * 获取指定邮箱的邮件发送服务
     * @param mailbox       邮箱
     * @return              邮件发送服务对象
     */
    MailSender getSender(EmailMailbox mailbox);
}
