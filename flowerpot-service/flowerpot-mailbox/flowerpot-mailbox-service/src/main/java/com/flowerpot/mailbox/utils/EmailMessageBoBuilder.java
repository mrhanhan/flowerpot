package com.flowerpot.mailbox.utils;

import com.flowerpot.common.utils.Builder;
import com.flowerpot.common.utils.UniqueCodeGen;
import com.flowerpot.common.utils.template.TemplateResolve;
import com.flowerpot.service.mailbox.dto.EmailMessageBo;
import com.flowerpot.service.mailbox.entity.EmailMessage;
import com.flowerpot.service.mailbox.entity.EmailMessageContent;
import com.flowerpot.service.mailbox.enums.EmailBusinessTypeEnum;
import com.flowerpot.service.mailbox.enums.EmailContentTypeEnum;
import com.flowerpot.service.mailbox.enums.EmailMailboxEnum;
import com.flowerpot.service.mailbox.enums.EmailStatusEnum;

import java.util.Arrays;

/**
 * EmailMessageBoBuilder
 *
 * @author Mrhan
 * @date 2021/5/29 13:16
 */
public class EmailMessageBoBuilder implements Builder<EmailMessageBo> {

    private final EmailMessage message;
    private final EmailMessageContent content;
    private EmailMailboxEnum mailboxEnum;

    public EmailMessageBoBuilder(Long userId) {
        message = new EmailMessage();
        message.setId(UniqueCodeGen.genId());
        message.setStatus(EmailStatusEnum.WAIT.getKey());
        // 默认HTML
        content = new EmailMessageContent();
        content.setId(UniqueCodeGen.genId());
        content.setContentType(EmailContentTypeEnum.TEXT_HTML.getKey());
        content.setEmailMessageId(message.getId());
    }

    public EmailMessageBoBuilder(Long userId, EmailMailboxEnum mailboxEnum) {
        this(userId);
        this.mailbox(mailboxEnum);
    }

    /**
     * 设置发邮件的邮箱
     * @param emailMailboxEnum      发邮件的邮箱枚举
     * @return                      EmailMessageBoBuilder
     */
    public EmailMessageBoBuilder mailbox(EmailMailboxEnum emailMailboxEnum) {
        this.mailboxEnum = emailMailboxEnum;
        return this;
    }

    /**
     * 标题
     * @param title     标题
     * @param subTitle  子标题
     * @return          标题
     */
    public EmailMessageBoBuilder title(String title, String subTitle) {
        message.setTitle(title);
        message.setSubTitle(subTitle);
        return this;
    }

    /**
     * 设置内容
     * @param templateResolve   模板解析器
     * @param templateName      模板名称
     * @param model             模板数据模型
     * @param contentTypeEnum   内容类型枚举
     * @return                  EmailMessageBoBuilder
     */
    public EmailMessageBoBuilder content(TemplateResolve templateResolve, String templateName, Object model, EmailContentTypeEnum contentTypeEnum) {
        content.setContentType(contentTypeEnum.getKey());
        // 设置内容
        content.setContent(templateResolve.resolve(templateName, model));
        return this;
    }

    /**
     * 设置内容
     * @param raw               内容
     * @param contentTypeEnum   内容类型枚举
     * @return                  EmailMessageBoBuilder
     */
    public EmailMessageBoBuilder content(String raw, EmailContentTypeEnum contentTypeEnum) {
        content.setContentType(contentTypeEnum.getKey());
        // 设置内容
        content.setContent(raw);
        return this;
    }

    /**
     * 邮箱的业务类型
     * @param emailBusinessTypeEnum 具体业务类型
     * @param bussId                业务ID
     * @return                      EmailMessageBoBuilder
     */
    public EmailMessageBoBuilder business(EmailBusinessTypeEnum emailBusinessTypeEnum, Long bussId) {
        message.setType(emailBusinessTypeEnum.getType().getKey());
        message.setBussType(emailBusinessTypeEnum.getKey());
        message.setBussId(bussId);
        return this;
    }

    /**
     * 发送邮件的目标
     * @param targets               邮件目标
     * @return                      EmailMessageBoBuilder
     */
    public EmailMessageBoBuilder targets(String ...targets) {
        message.setTargets(Arrays.toString(targets));
        return this;
    }


    @Override
    public EmailMessageBo build() {
        EmailMessageBo messageBo = new EmailMessageBo();
        messageBo.setMessage(message);
        messageBo.setContent(content);
        messageBo.setMailbox(mailboxEnum);
        return messageBo;
    }
}
