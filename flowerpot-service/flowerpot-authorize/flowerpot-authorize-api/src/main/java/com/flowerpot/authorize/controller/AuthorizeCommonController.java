package com.flowerpot.authorize.controller;

import com.flowerpot.authorize.entity.AuthResourceGroup;
import com.flowerpot.common.Result;
import com.flowerpot.service.authorize.service.AuthResourceGroupService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * AuthorizeCommonController
 *
 * @author Mrhan
 * @date 2021/7/10 10:39
 */
@RestController
@RequestMapping("/api/authorize/common")
@Api(tags = "授权服务-通用接口")
public class AuthorizeCommonController {

    @Resource
    private AuthResourceGroupService authResourceGroupService;

    /**
     * 获取全部的资源分组
     * @return  资源分组
     */
    @GetMapping("/resource/group")
    public Result<List<AuthResourceGroup>> getAllResourceGroup() {
        return Result.success(authResourceGroupService.list());
    }
}
