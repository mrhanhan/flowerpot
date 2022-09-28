package com.flowerpot.system.enums;

import com.flowerpot.common.KeyDescProvider;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author Mrhan
 * @date 2022/5/4 16:30
 */
@RequiredArgsConstructor
public enum SysMenuTypeEnum implements KeyDescProvider {

    /**
     * 菜单栏
     */
    MENU(1, "菜单栏"),
    /**
     * 权限
     */
    PERMISSION(2, "权限")

    ;

    private final int key;
    @Getter
    private final String desc;

    @Override
    public Integer getKey() {
        return key;
    }
}
