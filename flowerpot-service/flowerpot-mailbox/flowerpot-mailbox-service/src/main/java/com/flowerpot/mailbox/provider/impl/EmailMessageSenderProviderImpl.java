package com.flowerpot.mailbox.provider.impl;

import com.flowerpot.mailbox.provider.EmailMessageSenderProvider;
import com.flowerpot.service.mailbox.entity.EmailMailbox;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * EmailMessageSenderProviderImpl
 *
 * @author Mrhan
 * @date 2021/4/9 9:46
 */
@Slf4j
public class EmailMessageSenderProviderImpl implements EmailMessageSenderProvider {

    private static final String DEFAULT_ENCODING = "utf-8";

    @Override
    public MailSender getSender(EmailMailbox mailbox) {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();

        javaMailSender.setUsername(mailbox.getAccount());
        javaMailSender.setDefaultEncoding(DEFAULT_ENCODING);
        javaMailSender.setPassword(mailbox.getPassword());
        javaMailSender.setHost(mailbox.getMailHost());
        javaMailSender.setProtocol(mailbox.getMailProtocol());

        if (StringUtils.isNotBlank(mailbox.getMailPort())) {
            javaMailSender.setPort(Integer.parseInt(mailbox.getMailPort()));
        }

        javaMailSender.setJavaMailProperties(createProperties(mailbox));
        return javaMailSender;
    }

    /**
     * 创建邮箱配置Properties
     * @param mailbox   MailBox
     * @return  Properties
     */
    private Properties createProperties(EmailMailbox mailbox) {
        Properties properties = new Properties();
        try {
            properties.load(new ByteArrayInputStream(mailbox.getMailConfig().getBytes(StandardCharsets.UTF_8)));
        } catch (IOException e) {
            log.error("配置加载失败:", e);
        }
        return properties;
    }
}
