package com.flowerpot.service.mailbox.provider;

import com.flowerpot.service.storage.service.entity.EmailMailbox;
import com.flowerpot.service.storage.service.enums.EmailMailboxEnum;

/**
 * EmailMailboxProvider
 * 电子邮件邮箱服务提供者
 * @author Mrhan
 * @date 2021/4/9 9:21
 */
public interface EmailMailboxProvider {

    /**
     * 获取电子邮件邮箱
     * @param mailboxEnum   电子邮件邮箱枚举
     * @return              返回电子邮件邮箱对象
     */
    EmailMailbox get(EmailMailboxEnum mailboxEnum);
}
