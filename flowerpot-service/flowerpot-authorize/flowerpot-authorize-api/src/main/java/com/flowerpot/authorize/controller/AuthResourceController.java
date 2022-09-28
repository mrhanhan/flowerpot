package com.flowerpot.authorize.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowerpot.authorize.dto.param.AuthResourceParam;
import com.flowerpot.authorize.enums.AuthSystemEnum;
import com.flowerpot.authorize.constant.AuthorizeMessageConstant;
import com.flowerpot.common.PageRequest;
import com.flowerpot.common.PageResult;
import com.flowerpot.common.Result;
import com.flowerpot.common.VerifyForm;
import com.flowerpot.common.utils.Assert;
import com.flowerpot.authorize.entity.AuthResource;
import com.flowerpot.service.authorize.service.AuthResourceGroupService;
import com.flowerpot.service.authorize.service.AuthResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * AuthResourceController
 *
 * @author Mrhan
 * @date 2021/6/29 20:19
 */
@RestController
@RequestMapping("/api/authorize/auth")
@Api(tags = {"授权服务-授权资源"})
public class AuthResourceController implements VerifyForm<AuthResourceParam> {
    @Resource
    private AuthResourceService authResourceService;
    @Resource
    private AuthResourceGroupService authResourceGroupService;

    @ApiOperation("授权资源-分页")
    @GetMapping("/page")
    public PageResult<AuthResource> page(PageRequest request) {
        Page<AuthResource> page = request.toPage();
        authResourceService.lambdaQuery()
                .like(StringUtils.isNoneBlank(request.getSearchWord()), AuthResource::getName, request.getSearchWord())
                .page(page);
        return PageResult.create(page);
    }

    @ApiOperation("授权资源-保存")
    @PostMapping("/save")
    public Result<AuthResourceParam> save(@RequestBody AuthResourceParam authResource) {
        verifySaveForm(authResource);
        authResourceService.save(authResource);
        return Result.success(authResource);
    }

    @ApiOperation("授权资源-更新")
    @PostMapping("/update")
    public Result<AuthResourceParam> update(@RequestBody AuthResourceParam authResource) {
        verifySaveForm(authResource);
        authResourceService.update(authResource);
        return Result.success(authResource);
    }


    @ApiOperation("授权资源-验证CODE")
    @GetMapping("/verify/code")
    public Result<Boolean> verifyCode(Long id, String code) {
        return Result.success(verifyCodeExists(id, code));
    }

    @Override
    public void verifyForm(AuthResourceParam formData, int flag) {
        AuthResource authResource = formData.getAuthResource();
        Assert.notNull(authResource, AuthorizeMessageConstant.ILLEGAL_OPERATE);
//        Assert.notNull(formData.getAuthResourceRule(), AuthorizeMessageConstant.ILLEGAL_OPERATE);
        // 验证资源名称、code 分组
        Assert.notEmpty(authResource.getName(), AuthorizeMessageConstant.AUTH_RESOURCE_NAME_NOT_NULL);
        Assert.notEmpty(authResource.getCode(), AuthorizeMessageConstant.AUTH_RESOURCE_CODE_NULL);
        // 验证Code是否重复
        Assert.isTrue(verifyCodeExists(authResource.getId(), authResource.getCode()), AuthorizeMessageConstant.AUTH_RESOURCE_CODE_REPEAT);

        authResource.setSystem(AuthSystemEnum.CUSTOMIZE.getKey());
    }

    /**
     * 验证Code是否存在数据库中
     * @param id        记录ID
     * @param code      验证的code
     * @return  返回验证结果
     */
    private boolean verifyCodeExists(Long id, String code) {
        return authResourceService.lambdaQuery()
                .ne(Objects.nonNull(id), AuthResource::getId, id)
                .eq(AuthResource::getCode, code).count() < 1;
    }
}
