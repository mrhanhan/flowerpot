package com.flowerpot.service.system.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.flowerpot.common.model.BaseServiceImpl;
import com.flowerpot.common.utils.ConvertUtil;
import com.flowerpot.common.utils.UniqueCodeGen;
import com.flowerpot.common.utils.text.PasswordUtils;
import com.flowerpot.service.system.api.SysUserInfoService;
import com.flowerpot.service.system.api.SysUserService;
import com.flowerpot.service.system.common.dto.SysUserDto;
import com.flowerpot.service.system.common.entities.SysUser;
import com.flowerpot.service.system.common.entities.SysUserInfo;
import com.flowerpot.service.system.dao.SysUserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author Mrhan
 * @date 2021-03-18 23:23
 */
@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, SysUserMapper> implements SysUserService {

    @Resource
    private SysUserInfoService sysUserInfoService;

    @Override
    public Page<SysUserDto> getPage(Page<SysUserDto> page, SysUserDto search) {
        // 分页查询
        return baseMapper.getPage(page, search);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(SysUserDto sysUserDto) {
        // 设置ID
        if (Objects.isNull(sysUserDto.getId())) {
            sysUserDto.setId(UniqueCodeGen.genId());
        }
        SysUser user = createUser(sysUserDto);
        // 生成密码
        generatorPassword(user);
        // 生成头像
        generatorImage(user);
        // 保存User
        baseMapper.insert(user);
        // 保存UserInfo
        sysUserInfoService.save(createUserInfo(sysUserDto));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void modify(SysUserDto sysUserDto) {
        // 更新User
        baseMapper.updateById(createUser(sysUserDto));
        // 更新UserInfo
        sysUserInfoService.updateByUserId(createUserInfo(sysUserDto));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void remove(Long userId) {
        baseMapper.deleteById(userId);
        sysUserInfoService.removeByUserId(userId);
    }

    @Override
    public SysUserDto info(Long userId) {
        SysUserDto userDto = ConvertUtil.convert(getById(userId), SysUserDto.class);
        // 查询用户详情
        SysUserInfo userInfo = sysUserInfoService.getByUserId(userId);
        userDto.setAvatar(userInfo.getAvatar());
        userDto.setQq(userInfo.getQq());
        userDto.setPhone(userInfo.getPhone());
        return userDto;
    }

    // ============================================================== private methods ==============================================================

    /**
     * 生成头像
     * @param user      用户信息
     */
    private void generatorImage(SysUser user) {

    }

    /**
     * 生成密码
     * @param user      需要生成密码的用户
     */
    private void generatorPassword(SysUser user) {
        String password = PasswordUtils.generatorPassword();
        String slat = PasswordUtils.generatorSalt();
        String encryptPassword = PasswordUtils.encrypt(password, slat);

        user.setSalt(slat);
        user.setPassword(encryptPassword);
    }

    /**
     * 保存用户信息
     * @param sysUserDto        用户UserDTO
     * @return                  用户信息DTO
     */
    private SysUser createUser(SysUserDto sysUserDto) {
        return ConvertUtil.convert(sysUserDto, SysUser.class);
    }
    /**
     * 保存用户信息
     * @param sysUserDto        用户UserDTO
     * @return                  用户信息DTO
     */
    private SysUserInfo createUserInfo(SysUserDto sysUserDto) {
        SysUserInfo convert = ConvertUtil.convert(sysUserDto, SysUserInfo.class);
        convert.setId(null);
        convert.setUserId(sysUserDto.getId());
        return convert;
    }

}
