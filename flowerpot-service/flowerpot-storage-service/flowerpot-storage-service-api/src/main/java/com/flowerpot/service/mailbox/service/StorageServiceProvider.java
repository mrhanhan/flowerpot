package com.flowerpot.service.mailbox.service;

import com.flowerpot.service.storage.enums.StoreDeviceSupplierEnum;

import java.util.function.Function;

/**
 * StorageServiceProvider
 * 存储服务提供者
 * @author Mrhan
 * @date 2021/4/19 17:46
 */
public interface StorageServiceProvider extends Function<StoreDeviceSupplierEnum, StorageService> {

    /**
     * 验证存储设备是否可用
     * @param storeDeviceSupplierEnum   存储设备是否可用
     * @return                          返回存储设备状态，true代表可用
     */
    boolean validateStoreDeviceSupplier(StoreDeviceSupplierEnum storeDeviceSupplierEnum);

}
