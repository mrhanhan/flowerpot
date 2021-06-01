package com.flowerpot.admin.modules.mailbox.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowerpot.admin.modules.base.BaseController;
import com.flowerpot.common.PageRequest;
import com.flowerpot.common.PageResult;
import com.flowerpot.service.mailbox.service.EmailMailboxService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * EmailMailboxController
 * 邮箱控制器
 * @author Mrhan
 * @date 2021/5/30 14:33
 */
@RestController
@RequestMapping("/api/email/mailbox")
public class EmailMailboxController extends BaseController {

    @Resource
    private EmailMailboxService emailMailboxService;

    public PageResult<?> page(PageRequest request) {
        Page<Object> page = request.toPage();

        return PageResult.create(page);
    }
}
