package com.flowerpot.service.mailbox.service;

import javax.mail.Message;
import java.util.List;

/**
 * MailboxService
 * 邮箱服务
 * @author Mrhan
 * @date 2021/4/7 11:26
 */
public interface MailboxService {

    /**
     * 发送邮件
     * @param message   邮件消息
     * @param targetMailboxList     发送到的目标邮箱
     */
    void sendEmail(Message message, List<String> targetMailboxList);

}
