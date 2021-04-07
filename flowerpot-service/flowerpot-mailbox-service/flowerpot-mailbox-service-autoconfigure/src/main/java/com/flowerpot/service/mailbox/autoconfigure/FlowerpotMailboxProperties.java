package com.flowerpot.service.mailbox.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * FlowerpotMailboxProperties
 *
 * @author Mrhan
 * @date 2021/4/7 11:00
 */
@ConfigurationProperties(prefix = "flowerpot.mailbox")
@Data
public class FlowerpotMailboxProperties {
}
