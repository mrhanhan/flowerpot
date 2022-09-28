package com.flowerpot.authorize.enums;

import com.flowerpot.common.KeyDescProvider;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * AuthSystemEnum
 *
 * @author Mrhan
 * @date 2021/6/29 0:08
 */
@RequiredArgsConstructor
@Getter
public enum AuthSystemEnum implements KeyDescProvider {
    /**
     * 系统默认
     */
    SYSTEM(1, "系统资源组"),
    /**
     * 用户自定义
     */
    CUSTOMIZE(2, "用户资源组"),
    ;
    private final int key;
    private final String desc;

    @Override
    public Integer getKey() {
        return key;
    }
}
