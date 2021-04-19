package com.flowerpot.service.storage.service;

import com.flowerpot.service.storage.dto.StoreFileBo;
import com.flowerpot.service.storage.dto.StoreFileResultDto;

/**
 * StorageService
 * 存储服务
 * @author Mrhan
 * @date 2021/4/19 9:32
 */
public interface StorageService {

    /**
     * 存储内容
     * @param store     StoreFile
     * @return          返回保存的结果
     */
    StoreFileResultDto save(StoreFileBo store);

}
