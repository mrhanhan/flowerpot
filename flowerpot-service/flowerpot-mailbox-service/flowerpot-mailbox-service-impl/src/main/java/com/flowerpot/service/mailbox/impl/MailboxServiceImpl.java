package com.flowerpot.service.mailbox.impl;

import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.flowerpot.common.model.BaseEntity;
import com.flowerpot.common.utils.Asset;
import com.flowerpot.service.mailbox.dto.EmailMessageBo;
import com.flowerpot.service.mailbox.exception.EmailMailboxException;
import com.flowerpot.service.mailbox.provider.EmailMailboxProvider;
import com.flowerpot.service.mailbox.provider.EmailMessageSenderProvider;
import com.flowerpot.service.storage.service.EmailMailboxService;
import com.flowerpot.service.storage.service.EmailMessageContentService;
import com.flowerpot.service.storage.service.EmailMessageService;
import com.flowerpot.service.storage.service.MailboxService;
import com.flowerpot.service.storage.service.entity.EmailMailbox;
import com.flowerpot.service.storage.service.entity.EmailMessage;
import com.flowerpot.service.storage.service.entity.EmailMessageContent;
import com.flowerpot.service.storage.service.enums.EmailMailboxEnum;
import com.flowerpot.service.storage.service.enums.EmailStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailAuthenticationException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

/**
 * MailboxServiceImpl
 *
 * @author Mrhan
 * @date 2021/4/7 15:05
 */
@Slf4j
@Service
public class MailboxServiceImpl implements MailboxService {

    @Resource
    private EmailMessageSenderProvider emailMessageSenderProvider;
    @Resource
    private EmailMailboxService emailMailboxService;
    @Resource
    private EmailMessageService emailMessageService;
    @Resource
    private EmailMessageContentService emailMessageContentService;
    /**
     * 电子邮箱服务提供者
     */
    @Autowired(required = false)
    private List<EmailMailboxProvider> emailMailboxProviderList;

    @Override
    public void sendEmail(EmailMessageBo message) {
        // 获取电子邮件
        EmailMailbox emailMailbox = getEmailMailbox(message.getMailbox());
        // 保存对象数据
        saveEmailData(emailMailbox, message);
        EmailMessage emailMessage = message.getMessage();
        // 发送电子邮件
        Consumer<EmailStatusEnum> updateEmailMessageStatusFunc = (status) -> {
            LambdaUpdateChainWrapper<EmailMessage> wrapper = emailMessageService.lambdaUpdate();
            wrapper.set(EmailMessage::getStatus, EmailStatusEnum.SEND_SUCCESS.getKey()).eq(BaseEntity::getId, emailMailbox.getId());
            wrapper.update();
        };
        try {
            sendMail(emailMailbox, message);
            // 更新状态
            updateEmailMessageStatusFunc.accept(EmailStatusEnum.SEND_SUCCESS);
        }
        catch (EmailMailboxException e) {
            log.error("邮件发送失败:", e);
            updateEmailMessageStatusFunc.accept(EmailStatusEnum.SEND_EXCEPTION);
        }
        catch (Exception e) {
            log.error("邮件发送失败:", e);
            updateEmailMessageStatusFunc.accept(EmailStatusEnum.SEND_FAIL);
        }
    }

    /**
     * 保存电子邮件数据
     * @param emailMailbox  电子邮件邮箱
     * @param message       电子邮件消息
     */
    @Transactional(rollbackFor = Exception.class)
    public void saveEmailData(EmailMailbox emailMailbox, EmailMessageBo message) {
        EmailMessage emailMessage = message.getMessage();
        EmailMessageContent emailMessageContent = message.getContent();
        emailMessage.setMailboxId(emailMailbox.getId());

        emailMessageService.save(emailMessage);
        emailMessageContentService.save(emailMessageContent);
    }


    /**
     * 发送电子邮件
     * @param emailMailbox  EmailMessageBox
     * @param message       消息
     */
    private void sendMail(EmailMailbox emailMailbox, EmailMessageBo message) {
        // 获取邮件发送服务
        MailSender sender = getMailSender(emailMailbox);
        // 邮件消息
        SimpleMailMessage simpleMailMessage = createSimpleMailMessage(message, emailMailbox);
        // 发送邮件
        try {
            sender.send(simpleMailMessage);
        } catch (MailAuthenticationException e) {
            throw new EmailMailboxException(e);
        }
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
