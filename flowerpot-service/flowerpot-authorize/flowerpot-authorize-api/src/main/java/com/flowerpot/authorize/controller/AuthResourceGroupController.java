package com.flowerpot.authorize.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowerpot.authorize.constant.AuthorizeMessageConstant;
import com.flowerpot.authorize.entity.AuthResourceGroup;
import com.flowerpot.authorize.enums.AuthSystemEnum;
import com.flowerpot.authorize.service.AuthResourceGroupService;
import com.flowerpot.common.*;
import com.flowerpot.common.utils.Assert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * AuthResourceGroupController
 *
 * @author Mrhan
 * @date 2021/6/27 16:44
 */
@RestController
@RequestMapping("/api/authorize/auth_group")
@Api(tags = "授权服务-资源权限分组")
public class AuthResourceGroupController extends BaseController implements VerifyForm<AuthResourceGroup> {

    @Resource
    private AuthResourceGroupService authResourceGroupService;

    @ApiOperation("资源权限分组-分页")
    @GetMapping("/page")
    public PageResult<AuthResourceGroup> page(PageRequest request) {
        Page<AuthResourceGroup> page = request.toPage();
        authResourceGroupService.lambdaQuery()
                .like(StringUtils.isNoneBlank(request.getSearchWord()), AuthResourceGroup::getName, request.getSearchWord())
                .page(page);
        return PageResult.create(page);
    }

    @ApiOperation("资源权限分组-保存")
    @PostMapping("/save")
    public Result<AuthResourceGroup> save(@RequestBody AuthResourceGroup authResourceGroup) {
        verifySaveForm(authResourceGroup);
        authResourceGroup.setSystem(AuthSystemEnum.CUSTOMIZE.getKey());
        authResourceGroupService.save(authResourceGroup);
        return Result.success();
    }

    @ApiOperation("资源权限分组-获取")
    @GetMapping("/{id}")
    public Result<AuthResourceGroup> get(@PathVariable("id") Long id) {
        AuthResourceGroup data = authResourceGroupService.getById(id);
        Assert.notNull(data, AuthorizeMessageConstant.AUTH_RESOURCE_GROUP_NOT_EXISTS);
        return Result.success(data);
    }

    @ApiOperation("资源权限分组-更新")
    @PostMapping("/update")
    public Result<AuthResourceGroup> update(@RequestBody AuthResourceGroup authResourceGroup) {
        verifySaveForm(authResourceGroup);
        authResourceGroup.setSystem(AuthSystemEnum.CUSTOMIZE.getKey());
        authResourceGroupService.updateById(authResourceGroup);
        return Result.success();
    }


    @ApiOperation("资源权限分组-获取")
    @PostMapping("/{id}/delete")
    public Result<AuthResourceGroup> delete(@PathVariable("id") Long id) {
        AuthResourceGroup data = authResourceGroupService.getById(id);
        Assert.notNull(data, AuthorizeMessageConstant.AUTH_RESOURCE_GROUP_NOT_EXISTS);
        Assert.notEquals(data.getSystem(), AuthSystemEnum.SYSTEM.getKey(), AuthorizeMessageConstant.AUTH_RESOURCE_GROUP_CAN_NOT_DELETE);
        authResourceGroupService.removeById(id);
        return Result.success(data);
    }

    @Override
    public void verifyForm(AuthResourceGroup formData, int flag) {
        // 验证数据是否为空
        Assert.notNull(formData.getName(), AuthorizeMessageConstant.AUTH_RESOURCE_GROUP_NAME_NOT_NULL);
        if (isUpdate(flag)) {
            Assert.notNull(formData.getId(), AuthorizeMessageConstant.AUTH_RESOURCE_GROUP_NOT_EXISTS);
        }
    }
}
