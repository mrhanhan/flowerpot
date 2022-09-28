package com.flowerpot.storage.enums;

import com.flowerpot.common.KeyProvider;
import com.flowerpot.common.utils.config.ConfigTemplate;
import com.flowerpot.storage.service.StorageService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

/**
 * StorageServiceConstructEnum
 *
 * @author Mrhan
 * @date 2021/5/24 17:47
 */
@Getter
@RequiredArgsConstructor
public enum StorageServiceConstructEnum implements KeyProvider<com.flowerpot.storage.enums.StoreDeviceSupplierEnum> {

    ;

    private final com.flowerpot.storage.enums.StoreDeviceSupplierEnum key;
    private final Function<ConfigTemplate, StorageService> construct;
}
