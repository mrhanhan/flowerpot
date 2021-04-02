package com.flowerpot.service.system.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowerpot.common.model.BaseServiceImpl;
import com.flowerpot.service.system.api.SysUserService;
import com.flowerpot.service.system.common.dto.SysUserDto;
import com.flowerpot.service.system.common.entities.SysUser;
import com.flowerpot.service.system.dao.SysUserMapper;
import org.springframework.stereotype.Service;

/**
 * @author Mrhan
 * @date 2021-03-18 23:23
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, SysUserMapper> implements SysUserService {


    @Override
    public Page<SysUserDto> getPage(Page<SysUserDto> page, SysUserDto search) {
        // 分页查询
        return baseMapper.getPage(page, search);
    }
}
