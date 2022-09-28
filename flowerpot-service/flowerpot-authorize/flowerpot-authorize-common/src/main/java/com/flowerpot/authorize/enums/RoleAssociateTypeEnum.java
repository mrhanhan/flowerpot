package com.flowerpot.authorize.enums;

import com.flowerpot.common.KeyProvider;
import lombok.RequiredArgsConstructor;

/**
 * RoleAssociateTypeEnum
 *
 * @author Mrhan
 * @date 2021/8/3 23:48
 */
@RequiredArgsConstructor
public enum RoleAssociateTypeEnum implements KeyProvider<Integer> {

    /**
     * 用户 关系类型
     */
    USER(1)

    /**
     * 身份 关系类型
     */
    ,IDENTITY(1)


    ;
    private final int key;

    @Override
    public Integer getKey() {
        return key;
    }
}
