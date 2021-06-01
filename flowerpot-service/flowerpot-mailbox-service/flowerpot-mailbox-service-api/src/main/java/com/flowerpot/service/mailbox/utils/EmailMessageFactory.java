package com.flowerpot.service.mailbox.utils;

import com.flowerpot.service.mailbox.service.enums.EmailBusinessTypeEnum;
import com.flowerpot.service.mailbox.service.enums.EmailMailboxEnum;
import lombok.experimental.UtilityClass;

/**
 * EmailMessageBuilder
 * 邮件消息静态工厂对象
 * @author Mrhan
 * @date 2021/4/7 22:49
 */
@UtilityClass
public class EmailMessageFactory {

    /**
     * 创建 EmailMessageBoBuilder
     * @param userId                 用户ID
     * @param emailMailboxEnum       邮件邮箱枚举
     * @param bussId                 业务类型ID
     * @param emailBusinessTypeEnum  业务类型
     * @return EmailMessageBoBuilder
     */
    public EmailMessageBoBuilder create(Long userId, EmailMailboxEnum emailMailboxEnum, Long bussId, EmailBusinessTypeEnum emailBusinessTypeEnum) {
        EmailMessageBoBuilder builder = new EmailMessageBoBuilder(userId, emailMailboxEnum);
        builder.business(emailBusinessTypeEnum, bussId);
        return builder;
    }

}
