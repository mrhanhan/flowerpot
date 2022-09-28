package com.flowerpot.service.mailbox.service;

import com.flowerpot.common.model.BaseService;
import com.flowerpot.service.mailbox.entity.EmailMailbox;

import java.util.List;

/**
 * EmailMailboxService
 * 邮件邮箱
 * @author Mrhan
 * @date 2021/4/7 22:44
 */
public interface EmailMailboxService extends BaseService<EmailMailbox> {

    /**
     * 获取邮箱配置列表
     * @return  EmailMailbox
     */
    List<EmailMailbox> listMailboxSetting();

    /**
     * 更新邮件邮箱配置
     * @param mailbox EmailMailbox
     */
    void update(EmailMailbox mailbox);
}
