package com.flowerpot.service.system.api;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowerpot.common.model.BaseService;
import com.flowerpot.service.system.common.dto.SysUserDto;
import com.flowerpot.service.system.common.entities.SysUser;

/**
 * @author Mrhan
 * @date 2021-03-18 23:15
 */
public interface SysUserService extends BaseService<SysUser> {

    /**
     * 用户信息分页查询
     * @param page          分页查询对象
     * @param search        SysUserDto
     * @return              返回分页查询的对象
     */
    Page<SysUserDto> getPage(Page<SysUserDto> page, SysUserDto search);
}
