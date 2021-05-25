package com.flowerpot.service.mailbox.provider;

import com.flowerpot.service.mailbox.dto.EmailMessageBo;
import com.flowerpot.service.mailbox.service.entity.EmailMailbox;

/**
 * EmailMailboxProvider
 * 电子邮件邮箱服务提供者
 * @author Mrhan
 * @date 2021/4/9 9:21
 */
public interface EmailMailboxProvider {

    /**
     * 获取电子邮件邮箱
     * @param emailMessageBo 需要发送的邮件信息
     * @return              返回电子邮件邮箱对象
     */
    EmailMailbox get(EmailMessageBo emailMessageBo);
}
