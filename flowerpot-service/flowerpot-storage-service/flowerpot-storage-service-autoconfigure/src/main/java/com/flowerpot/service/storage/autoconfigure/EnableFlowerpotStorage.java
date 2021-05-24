package com.flowerpot.service.storage.autoconfigure;

import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * EnableFlowerpotStorage
 *
 * @author Mrhan
 * @date 2021/5/24 23:18
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented

@Import(FlowerpotStorageConfiguration.class)
public @interface EnableFlowerpotStorage {
}
