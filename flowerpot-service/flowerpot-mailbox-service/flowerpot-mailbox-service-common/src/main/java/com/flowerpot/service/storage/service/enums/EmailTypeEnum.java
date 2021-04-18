package com.flowerpot.service.storage.service.enums;

import com.flowerpot.common.KeyDescProvider;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * EmailTypeEnum
 * 邮件类型, 描述每一封邮件所属的类型和来源的业务描述，例如: 用户业务相关， 系统业务相关， 客户业务相关，商家业务相关，订单业务相关
 * @author Mrhan
 * @date 2021/4/7 11:46
 */
@Getter
@RequiredArgsConstructor
public enum EmailTypeEnum implements KeyDescProvider {
    /**
     * 用户相关业务发出的邮件，例如: 重置密码，找回密码。等等
     */
    USER_EMAIL(1, "用户业务相关"),
    /**
     * 系统业务相关发出的邮件， 例如: 新建账号需要用户设置密码，设置登录密码邮件， 新建账号验证码邮件
     */
    SYSTEM_EMAIL(2, "系统业务相关"),
    ;
    private final Integer key;
    private final String desc;

}
