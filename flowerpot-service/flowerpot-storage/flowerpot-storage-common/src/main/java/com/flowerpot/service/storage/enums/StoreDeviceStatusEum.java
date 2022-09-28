package com.flowerpot.storage.enums;

import com.flowerpot.common.KeyDescProvider;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * StoreDeviceStatusEum
 *
 * @author Mrhan
 * @date 2021/4/18 21:05
 */
@Getter
@RequiredArgsConstructor
public enum StoreDeviceStatusEum implements KeyDescProvider {
    /**
     * 设备状态
     */
    AVAILABLE(1, "可用"),
    /**
     * 不可用
     */
    ;

    private final Integer key;
    private final String desc;
}
