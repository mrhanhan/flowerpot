package com.flowerpot.service.mailbox.impl;

import com.flowerpot.common.model.BaseServiceImpl;
import com.flowerpot.service.mailbox.mapper.EmailMessageMapper;
import com.flowerpot.service.mailbox.service.EmailMessageService;
import com.flowerpot.service.mailbox.entity.EmailMessage;
import org.springframework.stereotype.Service;

/**
 * EmailMessageServiceImpl
 *
 * @author Mrhan
 * @date 2021/4/7 15:03
 */
@Service
public class EmailMessageServiceImpl extends BaseServiceImpl<EmailMessage, EmailMessageMapper> implements EmailMessageService {

}
