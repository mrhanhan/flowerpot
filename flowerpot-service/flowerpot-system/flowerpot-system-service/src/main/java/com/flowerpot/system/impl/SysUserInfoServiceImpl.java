package com.flowerpot.system.impl;


import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.flowerpot.common.model.BaseServiceImpl;
import com.flowerpot.system.service.SysUserInfoService;
import com.flowerpot.system.entity.SysUserInfo;
import com.flowerpot.system.mapper.SysUserInfoMapper;
import org.springframework.stereotype.Service;

/**
 * @author Mrhan
 * @date 2021-03-18 23:23
 */
@Service
public class SysUserInfoServiceImpl extends BaseServiceImpl<SysUserInfo, SysUserInfoMapper> implements SysUserInfoService {


    @Override
    public void updateByUserId(SysUserInfo userInfo) {
        LambdaUpdateWrapper<SysUserInfo> wrapper = Wrappers.lambdaUpdate();
        baseMapper.update(userInfo, wrapper.eq(SysUserInfo::getUserId, userInfo.getUserId()));
    }

    @Override
    public void removeByUserId(Long userId) {
        lambdaUpdate().eq(SysUserInfo::getUserId, userId).remove();
    }

    @Override
    public SysUserInfo getByUserId(Long userId) {
        return  lambdaQuery().eq(SysUserInfo::getUserId, userId).one();
    }
}
