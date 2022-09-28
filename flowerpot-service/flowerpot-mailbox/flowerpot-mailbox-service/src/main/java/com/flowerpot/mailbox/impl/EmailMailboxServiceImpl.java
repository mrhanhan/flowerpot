package com.flowerpot.mailbox.impl;

import com.flowerpot.common.model.BaseServiceImpl;
import com.flowerpot.common.utils.UniqueCodeGen;
import com.flowerpot.common.utils.collection.CollectionUtil;
import com.flowerpot.mailbox.mapper.EmailMailboxMapper;
import com.flowerpot.service.mailbox.entity.EmailMailbox;
import com.flowerpot.service.mailbox.enums.EmailMailboxEnum;
import com.flowerpot.mailbox.service.EmailMailboxService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * EmailMailboxServiceImpl
 * 邮件邮箱服务实现，实现对发送邮件的邮箱CRUD
 * @author Mrhan
 * @date 2021/4/7 22:45
 */
@Service
public class EmailMailboxServiceImpl extends BaseServiceImpl<EmailMailbox, EmailMailboxMapper> implements EmailMailboxService {
    @Override
    public List<EmailMailbox> listMailboxSetting() {
        // 查询数据库
        Map<String, EmailMailbox> mailboxMap = CollectionUtil.toMap(super.query().orderByDesc("id").list(), EmailMailbox::getCode);

        List<EmailMailbox> resultList = new ArrayList<>();
        List<EmailMailbox> insertList = new ArrayList<>();

        EmailMailboxEnum[] values = EmailMailboxEnum.values();
        EmailMailbox mailbox;
        for (EmailMailboxEnum value : values) {
            mailbox = mailboxMap.get(value.getCode());
            if (mailbox == null) {
                mailbox = createMailBox(value);
                insertList.add(mailbox);
            }
            resultList.add(mailbox);
        }
        if (!insertList.isEmpty()) {
            super.saveBatch(insertList);
        }
        return resultList;
    }

    @Override
    public void update(EmailMailbox mailbox) {
        super.lambdaUpdate().eq(EmailMailbox::getCode, mailbox.getCode()).update(mailbox);
    }

    /**
     * 创建Mailbox
     * @param value EmailMailboxEnum
     * @return      EmailMailbox
     */
    private EmailMailbox createMailBox(EmailMailboxEnum value) {
        EmailMailbox mailbox = new EmailMailbox();
        mailbox.setId(UniqueCodeGen.genId());
        mailbox.setCode(value.getCode());
        mailbox.setName(value.getName());
        mailbox.setDesc(value.getDesc());
        mailbox.setAccount("");
        mailbox.setPassword("");
        mailbox.setMailConfig("");
        mailbox.setMailHost("");
        mailbox.setMailPort("");
        mailbox.setMailProtocol("");
        return mailbox;
    }
}
