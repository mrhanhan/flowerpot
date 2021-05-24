package com.flowerpot.service.storage.impl;

import com.flowerpot.common.utils.ConvertUtil;
import com.flowerpot.common.utils.EnumUtil;
import com.flowerpot.common.utils.config.ConfigTemplate;
import com.flowerpot.service.storage.entity.StoreDevice;
import com.flowerpot.service.storage.enums.StorageServiceConstructEnum;
import com.flowerpot.service.storage.enums.StoreDeviceSupplierEnum;
import com.flowerpot.service.storage.service.StorageService;
import com.flowerpot.service.storage.service.StorageServiceProvider;
import com.flowerpot.service.storage.service.StoreDeviceService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * StorageServiceProviderImpl
 *
 * @author Mrhan
 * @date 2021/5/24 11:57
 */
@RequiredArgsConstructor
public class StorageServiceProviderImpl implements StorageServiceProvider {

    /**
     * 存储服务对象缓存
     */
    private final Map<Long, StorageService> storageServiceCacheMap = new HashMap<>();
    /**
     * 存储设备服务
     */
    @Getter
    private final StoreDeviceService deviceService;

    @Override
    public boolean isAvailable(Long deviceId) {
        if (storageServiceCacheMap.containsKey(deviceId)) {
            return true;
        }
        // 构建存储服务
        StoreDevice storeDevice = deviceService.getById(deviceId);
        if (Objects.isNull(storeDevice)) {
            return false;
        }
        // 获取类型
        StoreDeviceSupplierEnum storeDeviceSupplierEnum = EnumUtil.getByKey(StoreDeviceSupplierEnum.values(), storeDevice.getSupplier());
        if (Objects.isNull(storeDeviceSupplierEnum)) {
            return false;
        }
        StorageServiceConstructEnum storageServiceConstructEnum = EnumUtil.getByKey(StorageServiceConstructEnum.values(), storeDeviceSupplierEnum);
        if (Objects.isNull(storageServiceConstructEnum)) {
            return false;
        }
        // 转换为所需要的Properties
        try {
            ConfigTemplate template = ConvertUtil.jsonConvert(storeDevice.getConfig(), storeDeviceSupplierEnum.getPropertiesClass());
            StorageService apply = storageServiceConstructEnum.getConstruct().apply(template);
            // 服务是否可用
            if (!apply.isAvailable()) {
                return false;
            }
            // 放入缓存
            storageServiceCacheMap.put(deviceId, apply);
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public StorageService getStorageService(Long deviceId) {
        return storageServiceCacheMap.get(deviceId);
    }
}
