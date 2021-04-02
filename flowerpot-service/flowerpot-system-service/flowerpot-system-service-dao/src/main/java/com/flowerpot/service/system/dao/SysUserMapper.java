package com.flowerpot.service.system.dao;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowerpot.common.model.BaseMapper;
import com.flowerpot.service.system.common.dto.SysUserDto;
import com.flowerpot.service.system.common.entities.SysUser;
import org.apache.ibatis.annotations.Param;

/**
 * @author Mrhan
 * @date 2021-03-18 22:48
 */
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 分页查询
     * @param page          分页查询对象
     * @param search        搜索对象
     * @return              返回查询的对象
     */
    Page<SysUserDto> getPage(@Param("page") Page<SysUserDto> page, @Param("search") SysUserDto search);
}
