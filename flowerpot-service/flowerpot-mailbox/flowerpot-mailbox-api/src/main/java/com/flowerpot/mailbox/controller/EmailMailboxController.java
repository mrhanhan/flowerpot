package com.flowerpot.admin.modules.mailbox.controller;

import com.flowerpot.admin.modules.base.BaseController;
import com.flowerpot.common.Result;
import com.flowerpot.service.mailbox.entity.EmailMailbox;
import com.flowerpot.service.mailbox.service.EmailMailboxService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * EmailMailboxController
 * 邮箱控制器
 * @author Mrhan
 * @date 2021/5/30 14:33
 */
@RestController
@RequestMapping("/api/email/mailbox")
@Api(tags = {"邮箱服务-邮箱配置"})
public class EmailMailboxController extends BaseController {

    @Resource
    private EmailMailboxService emailMailboxService;

    @GetMapping("/list")
    @ApiOperation( value = "邮箱-列表")
    public Result<List<EmailMailbox>> list() {
        return Result.success(emailMailboxService.listMailboxSetting());
    }

    @PostMapping("/update")
    @ApiOperation( value = "邮箱-更新")
    public Result<EmailMailbox> update(@RequestBody EmailMailbox mailbox) {
        verifyForm(mailbox);
        emailMailboxService.update(mailbox);
        return Result.success(mailbox);
    }

    /**
     * 验证表单
     * @param mailbox   验证表单
     */
    private void verifyForm(EmailMailbox mailbox) {
        Assert.notNull(mailbox.getCode(), "mailbox.code.notnull");
    }
}
