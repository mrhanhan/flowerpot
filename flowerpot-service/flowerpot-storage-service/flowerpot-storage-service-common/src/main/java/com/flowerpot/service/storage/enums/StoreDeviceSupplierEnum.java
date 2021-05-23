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
    ALI_CLOUD_OSS_STORAGE("ali_cloud_oss_storage"),
    /**
     * 本地存储
     */
    LOCAL_STORAGE("local_storage")
    ;

    private final String key;

}
