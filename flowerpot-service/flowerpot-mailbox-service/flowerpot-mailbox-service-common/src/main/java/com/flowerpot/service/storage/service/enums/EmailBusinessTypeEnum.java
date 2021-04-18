package com.flowerpot.service.storage.service.enums;

import com.flowerpot.common.KeyDescProvider;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * EmailBusinessTypeEnum
 *
 * @author Mrhan
 * @date 2021/4/7 11:50
 */
@Getter
@RequiredArgsConstructor
public enum EmailBusinessTypeEnum implements KeyDescProvider {
    /**
     * 系统业务相关的邮件业务类型
     */
    SET_USER_LOGIN_PASSWORD(EmailTypeEnum.SYSTEM_EMAIL, 10, "设置用户登录密码"),

    ;
    private final EmailTypeEnum type;
    private final Integer key;
    private final String desc;
}
