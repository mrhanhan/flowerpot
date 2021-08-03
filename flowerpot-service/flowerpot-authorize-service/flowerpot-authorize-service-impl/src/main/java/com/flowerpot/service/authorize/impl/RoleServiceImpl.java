package com.flowerpot.service.authorize.impl;


import com.flowerpot.common.model.BaseServiceImpl;
import com.flowerpot.service.authorize.dto.param.RoleParam;
import com.flowerpot.service.authorize.entity.Role;
import com.flowerpot.service.authorize.mapper.RoleMapper;
import com.flowerpot.service.authorize.service.RoleAuthResourceService;
import com.flowerpot.service.authorize.service.RoleService;
import com.flowerpot.service.authorize.service.RoleTreeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Mrhan
 * @date 2021-06-07 14:58
 */
@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, RoleMapper> implements RoleService {

    @Resource
    private RoleAuthResourceService roleAuthResourceService;
    @Resource
    private RoleTreeService roleTreeService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RoleParam save(RoleParam param) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public RoleParam update(RoleParam param) {
        return null;
    }

    @Override
    public RoleParam detail(Long roleId) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Role delete(Long roleId) {
        return null;
    }
}
