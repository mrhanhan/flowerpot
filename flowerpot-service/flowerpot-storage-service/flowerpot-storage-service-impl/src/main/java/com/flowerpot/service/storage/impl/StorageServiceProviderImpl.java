package com.flowerpot.service.storage.impl;

import com.flowerpot.service.storage.enums.StoreDeviceSupplierEnum;
import com.flowerpot.service.storage.service.StorageService;
import com.flowerpot.service.storage.service.StorageServiceProvider;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * StorageServiceProviderImpl
 *
 * @author Mrhan
 * @date 2021/5/24 11:57
 */
@Service
public class StorageServiceProviderImpl implements StorageServiceProvider {

    @Resource
    private ConfigurableApplicationContext context;

    @Override
    public boolean validateStoreDeviceSupplier(StoreDeviceSupplierEnum storeDeviceSupplierEnum) {
        return true;
    }

    @Override
    public StorageService apply(StoreDeviceSupplierEnum storeDeviceSupplierEnum) {
        switch (storeDeviceSupplierEnum) {
            case LOCAL_STORAGE:

                return context.getBean(LocalFileStorageServiceImpl.class);
            case ALI_CLOUD_OSS_STORAGE:
                return context.getBean(AliCloudOssStorageServiceImpl.class);
            default: return context.getBean(LocalFileStorageServiceImpl.class);
        }
    }
}
