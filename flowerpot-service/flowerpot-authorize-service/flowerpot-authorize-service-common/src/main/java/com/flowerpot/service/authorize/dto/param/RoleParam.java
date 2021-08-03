package com.flowerpot.service.authorize.dto.param;

import com.flowerpot.service.authorize.entity.Role;
import com.flowerpot.service.authorize.entity.RoleAuthResource;
import lombok.Data;

import java.util.List;

/**
 * RoleParam
 *
 * @author Mrhan
 * @date 2021/8/2 16:25
 */
@Data
public class RoleParam {
    /**
     * 角色信息
     */
    private Role role;

    /**
     * 角色授权资源列表
     */
    private List<RoleAuthResource> roleAuthResourceList;
}
