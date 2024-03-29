package com.flowerpot.mailbox.impl;


import com.flowerpot.common.model.BaseServiceImpl;
import com.flowerpot.mailbox.mapper.EmailMessageContentMapper;
import com.flowerpot.mailbox.service.EmailMessageContentService;
import com.flowerpot.service.mailbox.entity.EmailMessageContent;
import org.springframework.stereotype.Service;

/**
 * EmailMessageContentServiceImpl
 *
 * @author Mrhan
 * @date 2021/4/7 15:03
 */
@Service
public class EmailMessageContentServiceImpl extends BaseServiceImpl<EmailMessageContent, EmailMessageContentMapper> implements EmailMessageContentService {

}
