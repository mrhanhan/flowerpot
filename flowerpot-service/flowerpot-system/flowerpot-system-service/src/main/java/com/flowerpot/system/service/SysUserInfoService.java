package com.flowerpot.system.service;


import com.flowerpot.common.model.BaseService;
import com.flowerpot.system.entity.SysUserInfo;

/**
 * @author Mrhan
 * @date 2021-03-18 23:15
 */
public interface SysUserInfoService extends BaseService<SysUserInfo> {

    /**
     * 根据用户信息
     * @param userInfo      用户UserInfo
     */
    void updateByUserId(SysUserInfo userInfo);

    /**
     * 根据UserId移除用户信息
     * @param userId        用户信息ID
     */
    void removeByUserId(Long userId);

    /**
     * 根据用户ID查询用户信息
     * @param userId        用户信息ID
     * @return              返回用户信息
     */
    SysUserInfo getByUserId(Long userId);
}
