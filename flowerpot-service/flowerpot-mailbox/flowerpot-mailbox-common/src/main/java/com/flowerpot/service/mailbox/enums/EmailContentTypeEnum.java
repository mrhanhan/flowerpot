package com.flowerpot.service.mailbox.enums;

import com.flowerpot.common.KeyDescProvider;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * EmailContentTypeEnum
 *
 * @author Mrhan
 * @date 2021/4/7 14:16
 */
@Getter
@RequiredArgsConstructor
public enum EmailContentTypeEnum implements KeyDescProvider {
    /**
     * Html 内容
     */
    TEXT_HTML(10, "text/html;charset=utf8;")
    ;
    private final Integer key;
    private final String desc;
}
