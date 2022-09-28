package com.flowerpot.authorize.service;


import com.flowerpot.common.model.BaseService;
import com.flowerpot.authorize.dto.param.AuthResourceParam;
import com.flowerpot.authorize.entity.AuthResource;

/**
 * @author Mrhan
 * @date 2021-06-07 14:58
 */
public interface AuthResourceService extends BaseService<AuthResource> {

    /**
     * 保存授权资源
     * @param authResourceParam 保存授权资源
     * @return  返回保存后的授权资源信息
     */
    AuthResourceParam save(AuthResourceParam authResourceParam);

    /**
     * 更新授权资源信息
     * @param authResourceParam 授权资源信息
     * @return  授权信息
     */
    AuthResourceParam update(AuthResourceParam authResourceParam);

    /**
     * 删除授权资源
     * @param id 授权资源ID
     * @return  返回已删除的授权资源信息
     */
    AuthResourceParam delete(Long id);

    /**
     * 获取记录详细信息
     * @param id    记录详细信息
     * @return      返回记录的详细信息
     */
    AuthResourceParam detail(Long id);
}
