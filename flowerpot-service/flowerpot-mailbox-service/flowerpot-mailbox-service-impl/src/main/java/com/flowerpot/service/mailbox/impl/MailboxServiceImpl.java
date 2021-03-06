package com.flowerpot.service.mailbox.impl;

import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.flowerpot.common.model.BaseEntity;
import com.flowerpot.common.utils.Assert;
import com.flowerpot.service.mailbox.dto.EmailMessageBo;
import com.flowerpot.service.mailbox.exception.EmailMailboxException;
import com.flowerpot.service.mailbox.provider.EmailMailboxProvider;
import com.flowerpot.service.mailbox.provider.EmailMessageSenderProvider;
import com.flowerpot.service.mailbox.service.EmailMailboxService;
import com.flowerpot.service.mailbox.service.EmailMessageContentService;
import com.flowerpot.service.mailbox.service.EmailMessageService;
import com.flowerpot.service.mailbox.service.MailboxService;
import com.flowerpot.service.mailbox.entity.EmailMailbox;
import com.flowerpot.service.mailbox.entity.EmailMessage;
import com.flowerpot.service.mailbox.entity.EmailMessageContent;
import com.flowerpot.service.mailbox.enums.EmailStatusEnum;
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
     * ???????????????????????????
     */
    @Autowired(required = false)
    private List<EmailMailboxProvider> emailMailboxProviderList;

    @Override
    public void sendEmail(EmailMessageBo message) {
        // ??????????????????
        EmailMailbox emailMailbox = getEmailMailbox(message);
        // ??????????????????
        saveEmailData(emailMailbox, message);
        // ??????????????????
        Consumer<EmailStatusEnum> updateEmailMessageStatusFunc = (status) -> {
            LambdaUpdateChainWrapper<EmailMessage> wrapper = emailMessageService.lambdaUpdate();
            wrapper.set(EmailMessage::getStatus, EmailStatusEnum.SEND_SUCCESS.getKey()).eq(BaseEntity::getId, emailMailbox.getId());
            wrapper.update();
        };
        try {
            sendMail(emailMailbox, message);
            // ????????????
            updateEmailMessageStatusFunc.accept(EmailStatusEnum.SEND_SUCCESS);
        }
        catch (EmailMailboxException e) {
            log.error("??????????????????:", e);
            updateEmailMessageStatusFunc.accept(EmailStatusEnum.SEND_EXCEPTION);
        }
        catch (Exception e) {
            log.error("??????????????????:", e);
            updateEmailMessageStatusFunc.accept(EmailStatusEnum.SEND_FAIL);
        }
    }

    /**
     * ????????????????????????
     * @param emailMailbox  ??????????????????
     * @param message       ??????????????????
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
     * ??????????????????
     * @param emailMailbox  EmailMessageBox
     * @param message       ??????
     */
    private void sendMail(EmailMailbox emailMailbox, EmailMessageBo message) {
        // ????????????????????????
        MailSender sender = getMailSender(emailMailbox);
        // ????????????
        SimpleMailMessage simpleMailMessage = createSimpleMailMessage(message, emailMailbox);
        // ????????????
        try {
            sender.send(simpleMailMessage);
        } catch (MailAuthenticationException e) {
            throw new EmailMailboxException(e);
        }
    }

    /**
     * ????????????????????????
     * @param message   ?????????????????????Bo??????
     * @param emailMailbox  ????????????????????????
     * @return          ?????????????????????????????????
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
     * ????????????????????????????????????????????????
     *
     * @param emailMailbox ??????????????????
     * @return ?????????????????????
     */
    private MailSender getMailSender(EmailMailbox emailMailbox) {
        // ????????????????????????
        MailSender sender = emailMessageSenderProvider.getSender(emailMailbox);
        Assert.notNull(emailMailbox, "??????????????????????????????");
        return sender;
    }

    /**
     * EmailMailbox
     *
     * @param emailMessageBo ??????BO
     * @return ??????????????????????????????
     */
    private EmailMailbox getEmailMailbox(EmailMessageBo emailMessageBo) {
        EmailMailbox mailbox = null;
        if (!CollectionUtils.isEmpty(emailMailboxProviderList)) {
            for (EmailMailboxProvider provider : emailMailboxProviderList) {
                mailbox = provider.get(emailMessageBo);
                if (Objects.nonNull(mailbox)) {
                    return mailbox;
                }
            }
        }
        mailbox = emailMailboxService.getById(emailMessageBo.getMailbox().getId());
        Assert.notNull(mailbox, "??????????????????");
        return mailbox;
    }
}
