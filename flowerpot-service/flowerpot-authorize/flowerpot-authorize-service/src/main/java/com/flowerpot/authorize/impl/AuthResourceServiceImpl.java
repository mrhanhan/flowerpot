package com.flowerpot.authorize.impl;


import com.flowerpot.authorize.service.AuthResourceRuleService;
import com.flowerpot.common.model.BaseServiceImpl;
import com.flowerpot.common.utils.Assert;
import com.flowerpot.common.utils.UniqueCodeGen;
import com.flowerpot.authorize.dto.param.AuthResourceParam;
import com.flowerpot.authorize.entity.AuthResource;
import com.flowerpot.authorize.entity.AuthResourceRule;
import com.flowerpot.authorize.mapper.AuthResourceMapper;
import com.flowerpot.authorize.service.AuthResourceService;
import com.flowerpot.authorize.utils.AuthResourceConverts;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author Mrhan
 * @date 2021-06-07 14:58
 */
@Service
public class AuthResourceServiceImpl extends BaseServiceImpl<AuthResource, AuthResourceMapper> implements AuthResourceService {

    @Resource
    private AuthResourceRuleService authResourceRuleService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AuthResourceParam save(AuthResourceParam authResourceParam) {
        // 保存
        AuthResource authResource = authResourceParam.getAuthResource();
        if (Objects.isNull(authResource.getId())) {
            authResource.setId(UniqueCodeGen.genId());
        }
        Assert.isTrue(super.save(authResource), "保存失败");
        // 保存规则
        saveRule(authResource, authResourceParam);
        return authResourceParam;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public AuthResourceParam update(AuthResourceParam authResourceParam) {
        AuthResource authResource = authResourceParam.getAuthResource();
        // 删除规则
        deleteRule(authResource.getId());
        Assert.isTrue(super.updateById(authResource), "更新失败");
        // 保存规则
        saveRule(authResource, authResourceParam);
        return authResourceParam;
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public AuthResourceParam delete(Long id) {
        // 查询记录
        AuthResource authResource = super.getById(id);
        Assert.notNull(authResource, "删除失败,记录不存在");
        super.removeById(id);
        // 删除规则
        deleteRule(id);
        return AuthResourceConverts.convertAuthResourceParam(authResource, null);
    }

    @Override
    public AuthResourceParam detail(Long id) {
        AuthResource authResource = super.getById(id);
        return AuthResourceConverts.convertAuthResourceParam(authResource, getRuleList(id));
    }

    /**
     * 查询授权记录规则信息
     * @param resourceId    资源记录ID
     * @return              返回资源规则列表
     */
    private List<AuthResourceRule> getRuleList(Long resourceId) {
        return authResourceRuleService.lambdaQuery().eq(AuthResourceRule::getResourceId, resourceId).list();
    }

    /**
     * 删除规则信息
     * @param resourceId        授权资源ID
     */
    private void deleteRule(Long resourceId) {
        authResourceRuleService.lambdaUpdate().eq(AuthResourceRule::getResourceId, resourceId).remove();
    }
    /**
     * 保存规则
     * @param authResource       资源对象
     * @param authResourceParam  资源规则信息
     */
    private void saveRule( AuthResource authResource, AuthResourceParam authResourceParam) {
        if(Objects.nonNull(authResourceParam.getAuthResourceRule())) {
            authResourceRuleService.saveBatch(AuthResourceConverts.convertAuthResourceRuleList(authResourceParam.getAuthResourceRule(), authResource.getId()));
        }
    }
}
