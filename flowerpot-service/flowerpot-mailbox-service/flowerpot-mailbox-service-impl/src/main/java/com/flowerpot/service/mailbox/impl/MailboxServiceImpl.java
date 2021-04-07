package com.flowerpot.service.mailbox.impl;

import com.flowerpot.service.mailbox.service.MailboxService;

import javax.mail.Message;
import java.util.List;

/**
 * MailboxServiceImpl
 *
 * @author Mrhan
 * @date 2021/4/7 15:05
 */
public class MailboxServiceImpl  implements MailboxService {

    @Override
    public void sendEmail(Message message, List<String> targetMailboxList) {

    }
}
