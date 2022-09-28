package com.flowerpot.system.service;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowerpot.common.model.BaseService;
import com.flowerpot.service.system.dto.SysUserDto;
import com.flowerpot.service.system.entity.SysUser;

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

    /**
     * 保存
     * @param sysUserDto    系统用户DTO
     */
    void save(SysUserDto sysUserDto);


    /**
     * 更改
     * @param sysUserDto    系统用户DTO
     */
    void modify(SysUserDto sysUserDto);

    /**
     * 移除用户ID
     * @param userId        用户ID
     */
    void remove(Long userId);

    /**
     * 查询用户详情
     * @param userId        用户ID
     * @return              返回用户DTO
     */
    SysUserDto info(Long userId);
}
