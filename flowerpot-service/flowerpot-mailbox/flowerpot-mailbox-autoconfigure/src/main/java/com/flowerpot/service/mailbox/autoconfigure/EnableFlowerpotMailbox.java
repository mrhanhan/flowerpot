package com.flowerpot.service.mailbox.autoconfigure;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * EnableFlowerpotMailbox
 * 启用花盆Mailbox服务
 * @author Mrhan
 * @date 2021/4/7 10:50
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented

@Import(FlowerpotMailboxConfiguration.class)
public @interface EnableFlowerpotMailbox {

}
