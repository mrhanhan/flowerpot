package com.flowerpot.storage.autoconfigure;

import com.flowerpot.storage.impl.StorageServiceProviderImpl;
import com.flowerpot.storage.service.StorageServiceProvider;
import com.flowerpot.storage.service.StoreDeviceService;
import org.springframework.context.annotation.Bean;

/**
 * FlowerpotStorageConfiguration
 * 存储服务
 * @author Mrhan
 * @date 2021/5/24 23:19
 */
public class FlowerpotStorageConfiguration {

    @Bean
    public StorageServiceProvider storageServiceProvider(StoreDeviceService deviceService) {
        return new StorageServiceProviderImpl(deviceService);
    }
}
