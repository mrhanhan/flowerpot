package com.flowerpot.service.storage.service.enums;

import com.flowerpot.common.KeyDescProvider;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * EmailStatusEnum
 * 邮件状态枚举
 * @author Mrhan
 * @date 2021/4/7 11:57
 */
@Getter
@RequiredArgsConstructor
public enum EmailStatusEnum implements KeyDescProvider {
    /**
     * 已发送
     */
    SEND_SUCCESS(10, "已发送"),
    SEND_FAIL(20, "发送失败"),
    SEND_EXCEPTION(30, "邮件系统异常"),
    ;
    private final Integer key;
    private final String desc;
}
