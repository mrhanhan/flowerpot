package com.flowerpot.service.mailbox.autoconfigure;

import com.flowerpot.mailbox.provider.EmailMessageSenderProvider;
import com.flowerpot.mailbox.provider.impl.EmailMessageSenderProviderImpl;
import org.springframework.context.annotation.Bean;

/**
 * FlowerpotMailboxConfiguration
 *
 * @author Mrhan
 * @date 2021/4/7 10:53
 */
public class FlowerpotMailboxConfiguration {

    public FlowerpotMailboxConfiguration() {

    }

    @Bean
    public EmailMessageSenderProvider messageSenderProvider() {
        return new EmailMessageSenderProviderImpl();
    }
}
