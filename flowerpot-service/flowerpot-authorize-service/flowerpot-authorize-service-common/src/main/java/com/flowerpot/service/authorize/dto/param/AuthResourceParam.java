package com.flowerpot.service.authorize.dto.param;

import com.flowerpot.service.authorize.entity.AuthResource;
import lombok.Data;

/**
 * AuthResourceParam
 *
 * @author Mrhan
 * @date 2021/7/17 18:54
 */
@Data
public class AuthResourceParam {
    /**
     * 授权资源
     */
    private AuthResource authResource;
    /**
     * 授权资源规则
     */
    private AuthResourceRuleParam authResourceRule;
}
