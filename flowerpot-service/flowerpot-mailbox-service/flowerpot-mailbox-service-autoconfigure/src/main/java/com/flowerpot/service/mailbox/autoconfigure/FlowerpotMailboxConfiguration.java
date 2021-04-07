package com.flowerpot.service.mailbox.autoconfigure;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * FlowerpotMailboxConfiguration
 *
 * @author Mrhan
 * @date 2021/4/7 10:53
 */
@Configuration
@EnableConfigurationProperties(FlowerpotMailboxProperties.class)
public class FlowerpotMailboxConfiguration {

    public FlowerpotMailboxConfiguration() {
        System.out.println("mailbox");
    }
}
