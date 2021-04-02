package com.flowerpot.admin.modules.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowerpot.admin.modules.base.BaseController;
import com.flowerpot.common.PageRequest;
import com.flowerpot.common.PageResult;
import com.flowerpot.service.system.api.SysUserService;
import com.flowerpot.service.system.common.dto.SysUserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * SysUserController
 *
 * @author Mrhan
 * @date 2021/4/2 11:22
 */
@Api(tags = "系统管理-用户管理接口")
@RestController
@RequestMapping("/api/system/user")
public class SysUserController extends BaseController {

    @Resource
    private SysUserService sysUserService;

    @GetMapping("/page")
    @ApiOperation("分页")
    public PageResult<SysUserDto> page(PageRequest request, SysUserDto search) {
        Page<SysUserDto> page = request.toPage();
        page = sysUserService.getPage(page, search);
        return PageResult.create(page);
    }
}
