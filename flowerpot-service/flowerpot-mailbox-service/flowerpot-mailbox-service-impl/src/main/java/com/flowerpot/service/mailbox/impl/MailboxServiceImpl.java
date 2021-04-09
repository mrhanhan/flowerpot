package com.flowerpot.service.mailbox.impl;

import com.flowerpot.common.utils.Asset;
import com.flowerpot.service.mailbox.dto.EmailMessageBo;
import com.flowerpot.service.mailbox.provider.EmailMailboxProvider;
import com.flowerpot.service.mailbox.provider.EmailMessageSenderProvider;
import com.flowerpot.service.mailbox.service.EmailMailboxService;
import com.flowerpot.service.mailbox.service.MailboxService;
import com.flowerpot.service.mailbox.service.entity.EmailMailbox;
import com.flowerpot.service.mailbox.service.entity.EmailMessage;
import com.flowerpot.service.mailbox.service.entity.EmailMessageContent;
import com.flowerpot.service.mailbox.service.enums.EmailMailboxEnum;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * MailboxServiceImpl
 *
 * @author Mrhan
 * @date 2021/4/7 15:05
 */
@Service
public class MailboxServiceImpl implements MailboxService {

    @Resource
    private EmailMessageSenderProvider emailMessageSenderProvider;
    @Resource
    private EmailMailboxService emailMailboxService;
    /**
     * 电子邮箱服务提供者
     */
    private final List<EmailMailboxProvider> emailMailboxProviderList;

    public MailboxServiceImpl(@Autowired(required = false) List<EmailMailboxProvider> emailMailboxProviderList) {
        this.emailMailboxProviderList = emailMailboxProviderList;
    }

    @Override
    public void sendEmail(EmailMessageBo message) {
        // 获取电子邮件
        // Email Mailbox
        EmailMailbox emailMailbox = getEmailMailbox(message.getMailbox());
        // 获取邮件发送服务
        MailSender sender = getMailSender(emailMailbox);
        // 邮件消息
        SimpleMailMessage simpleMailMessage = createSimpleMailMessage(message, emailMailbox);
        // 发送邮件
        sender.send(simpleMailMessage);
    }

    /**
     * 创建邮件消息对象
     * @param message   需要发送的邮件Bo对象
     * @param emailMailbox  电子邮件邮箱对象
     * @return          返回生成的邮件消息对象
     */
    private SimpleMailMessage createSimpleMailMessage(EmailMessageBo message, EmailMailbox emailMailbox) {
        EmailMessage emailMessage = message.getMessage();
        EmailMessageContent emailMessageContent = message.getContent();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(emailMailbox.getAccount());
        simpleMailMessage.setTo(StringUtils.strip(emailMessage.getTargets()));
        simpleMailMessage.setSentDate(new Date());
        simpleMailMessage.setText(emailMessageContent.getContent());
        return simpleMailMessage;
    }

    /**
     * 根据邮箱枚举获取邮件发送服务对象
     *
     * @param emailMailbox 电子邮箱对象
     * @return 邮箱发送者服务
     */
    private MailSender getMailSender(EmailMailbox emailMailbox) {
        // 获取邮件发送服务
        MailSender sender = emailMessageSenderProvider.getSender(emailMailbox);
        Asset.notNull(emailMailbox, "邮件发送服务获取失败");
        return sender;
    }

    /**
     * EmailMailbox
     *
     * @param mailboxEnum 电子邮件邮箱枚举
     * @return 返回电子邮件邮箱对象
     */
    private EmailMailbox getEmailMailbox(EmailMailboxEnum mailboxEnum) {
        EmailMailbox mailbox = null;
        if (!CollectionUtils.isEmpty(emailMailboxProviderList)) {
            for (EmailMailboxProvider provider : emailMailboxProviderList) {
                mailbox = provider.get(mailboxEnum);
                if (Objects.nonNull(mailbox)) {
                    return mailbox;
                }
            }
        }
        mailbox = emailMailboxService.getById(mailboxEnum.getId());
        Asset.notNull(mailbox, "电子邮箱未空");
        return mailbox;
    }
}
