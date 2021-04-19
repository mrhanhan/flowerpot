package com.flowerpot.service.storage.enums;

import com.flowerpot.common.KeyProvider;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * StoreDeviceSupplierEnum
 *
 * @author Mrhan
 * @date 2021/4/18 22:44
 */
@Getter
@RequiredArgsConstructor
public enum StoreDeviceSupplierEnum implements KeyProvider<String> {

    /**
     * 阿里云 OSS
     */
    ALI_CLOUD_OSS("ali_cloud_oss")

    ;

    private final String key;

}
