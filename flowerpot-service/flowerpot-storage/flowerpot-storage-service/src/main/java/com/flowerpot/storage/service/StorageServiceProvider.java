package com.flowerpot.service.storage.service;

/**
 * StorageServiceProvider
 * 存储服务提供者
 * @author Mrhan
 * @date 2021/4/19 17:46
 */
public interface StorageServiceProvider {

    /**
     * 验证存储设备是否可用
     * @param deviceId   设备ID
     * @return           返回存储设备状态，true代表可用
     */
    boolean isAvailable(Long deviceId);

    /**
     * 获取指定设备的存储服务
     * @param deviceId  存储服务
     * @return          返回存储服务信息
     */
    StorageService getStorageService(Long deviceId);
}
