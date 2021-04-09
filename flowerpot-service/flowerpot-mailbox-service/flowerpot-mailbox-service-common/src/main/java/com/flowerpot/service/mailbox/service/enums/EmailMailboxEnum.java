package com.flowerpot.service.mailbox.service.enums;

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

    ;

    private final Long id;
    private final String code;
    private final String name;
    private final String host;
    private final String port;


    @Override
    public Integer getKey() {
        return id.intValue();
    }

    @Override
    public String getDesc() {
        return name;
    }
}
