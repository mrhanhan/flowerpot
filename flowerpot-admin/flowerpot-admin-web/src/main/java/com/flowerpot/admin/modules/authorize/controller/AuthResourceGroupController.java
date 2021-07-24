package com.flowerpot.admin.modules.authorize.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowerpot.admin.modules.authorize.constant.AuthorizeMessageConstant;
import com.flowerpot.admin.modules.base.BaseController;
import com.flowerpot.common.PageRequest;
import com.flowerpot.common.PageResult;
import com.flowerpot.common.Result;
import com.flowerpot.common.VerifyForm;
import com.flowerpot.common.utils.Assert;
import com.flowerpot.service.authorize.entity.AuthResourceGroup;
import com.flowerpot.service.authorize.enums.AuthSystemEnum;
import com.flowerpot.service.authorize.service.AuthResourceGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
