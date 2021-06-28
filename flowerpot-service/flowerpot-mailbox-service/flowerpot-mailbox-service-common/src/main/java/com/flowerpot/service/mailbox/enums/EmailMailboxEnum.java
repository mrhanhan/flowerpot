package com.flowerpot.service.mailbox.enums;

import com.flowerpot.common.KeyDescProvider;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * MailboxEnum
 *
 * @author Mrhan
 * @date 2021/4/7 21:52
 */
@Getter
@RequiredArgsConstructor
public enum EmailMailboxEnum implements KeyDescProvider {
    /**
     * 默认邮箱
     */
    SYSTEM_DEFAULT_MAILBOX( 1000L, "SYSTEM_DEFAULT_MAILBOX", "系统默认邮箱")
    ;

    private final Long id;
    private final String code;
    private final String name;


    @Override
    public Integer getKey() {
        return id.intValue();
    }

    @Override
    public String getDesc() {
        return name;
    }
}
