package com.flowerpot.service.mailbox.impl;

import com.flowerpot.common.model.BaseServiceImpl;
import com.flowerpot.service.mailbox.mapper.EmailMailboxMapper;
import com.flowerpot.service.mailbox.service.EmailMailboxService;
import com.flowerpot.service.mailbox.entity.EmailMailbox;
import org.springframework.stereotype.Service;

/**
 * EmailMailboxServiceImpl
 * 邮件邮箱服务实现，实现对发送邮件的邮箱CRUD
 * @author Mrhan
 * @date 2021/4/7 22:45
 */
@Service
public class EmailMailboxServiceImpl extends BaseServiceImpl<EmailMailbox, EmailMailboxMapper> implements EmailMailboxService {
}
