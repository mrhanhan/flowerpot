package com.flowerpot.authorize.service;


import com.flowerpot.common.model.BaseService;
import com.flowerpot.authorize.dto.param.RoleParam;
import com.flowerpot.authorize.entity.Role;

/**
 * @author Mrhan
 * @date 2021-06-07 14:58
 */
public interface RoleService extends BaseService<Role> {

    /**
     * 保存角色
     * @param param 参数
     * @return  返回保存之后得角色信息
     */
    RoleParam save(RoleParam param);


    /**
     * 更新角色
     * @param param 参数
     * @return  返回保存之后得角色信息
     */
    RoleParam update(RoleParam param);

    /**
     * 角色ID
     * @param roleId 角色ID
     * @return 单会角色参数
     */
    RoleParam detail(Long roleId);

    /**
     * 删除角色信息
     * @param roleId 角色ID
     * @return  返回角色记录
     */
    Role delete(Long roleId);
}
