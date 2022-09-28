package com.flowerpot.authorize.dto.param;

import com.flowerpot.authorize.dto.AuthRuleExpression;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * AuthResourceRuleParam
 * 授权资源列表
 * @author Mrhan
 * @date 2021/7/17 18:54
 */
@Data
public class AuthResourceRuleParam {
    /**
     * 规则记录ID
     */
    private Long id;
    /**
     * 受权资源类型
     */
    @NotNull(message = "授权资源规则类型不能为空")
    private Integer type;
    /**
     * 表达式
     */
    @NotNull(message = "授权资源规则表达式不能为空")
    private AuthRuleExpression expression;
    /**
     * 子表达式
     */
    private List<AuthResourceRuleParam> children;
    /**
     * 描述信息
     */
    private String desc;
}
