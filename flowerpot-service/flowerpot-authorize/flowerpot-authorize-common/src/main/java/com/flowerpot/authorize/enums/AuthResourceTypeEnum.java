package com.flowerpot.authorize.enums;

import com.flowerpot.common.KeyProvider;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * AuthResourceTypeEnum
 * 受权资源类型Enum
 * 不同的资源类型做出的操作可能不同。
 * 例如:
 *  如果是url类型，在网关上是需要进行权限拦截的
 *  如果是按钮类型，有可能是需要登陆时返回给前端或者提供受权验证接口（可见即可操作）
 * @author Mrhan
 * @date 2021/6/27 12:14
 */
@RequiredArgsConstructor
@Getter
public enum AuthResourceTypeEnum implements KeyProvider<Integer> {
    /**
     * URL, URL类型的受权资源是在网关会进行对此类型受权资源进行权限拦截的
     */
    URL(1),
    /**
     * 授权码/按钮，一个关联的key,网关不会对其进行处理。由具体需求硬编码完成
     */
    IDENTIFIER(2),
    ;

    private final Integer key;
}
