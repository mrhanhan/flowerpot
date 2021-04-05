package com.flowerpot.admin.modules.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowerpot.admin.modules.base.BaseController;
import com.flowerpot.common.PageRequest;
import com.flowerpot.common.PageResult;
import com.flowerpot.common.Result;
import com.flowerpot.service.system.api.SysUserService;
import com.flowerpot.service.system.common.dto.SysUserDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

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

    @PostMapping("/save")
    @ApiOperation("保存")
    public Result<SysUserDto> save(@RequestBody SysUserDto sysUserDto) {
        // 表单验证
        verifyForm(sysUserDto, true);
        // 填充数据
        setDefaultData(sysUserDto);
        sysUserService.save(sysUserDto);
        return Result.success(sysUserDto);
    }


    @PostMapping("/modify")
    @ApiOperation("更改")
    public Result<SysUserDto> modify(@RequestBody SysUserDto sysUserDto) {
        // 表单验证
        verifyForm(sysUserDto, false);
        sysUserService.modify(sysUserDto);
        return Result.success(sysUserDto);
    }

    @GetMapping("/{id}")
    @ApiOperation("详情")
    public Result<SysUserDto> info(@PathVariable("id") Long id) {
        return Result.success(sysUserService.info(id));
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除")
    public Result<?> delete(@PathVariable("id") Long id) {
        sysUserService.remove(id);
        return Result.success();
    }

    /**
     * 表单验证
     * @param sysUserDto        SysUserDto
     * @param isSave            是否是保存
     */
    private void verifyForm(SysUserDto sysUserDto, boolean isSave) {

    }

    /**
     * 设置默认数据
     * @param sysUserDto       SysUserDto
     */
    private void setDefaultData(SysUserDto sysUserDto) {
        if (Objects.isNull(sysUserDto.getDeptId())) {
            sysUserDto.setDeptId(0L);
        }
        if (Objects.isNull(sysUserDto.getRoleId())) {
            sysUserDto.setRoleId(0L);
        }
    }
}
