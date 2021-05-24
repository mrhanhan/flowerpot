package com.flowerpot.service.storage.service;

import com.flowerpot.service.storage.dto.StoreFileBo;
import com.flowerpot.service.storage.dto.StoreFileResultDto;

import java.io.InputStream;

/**
 * StorageService
 * 存储服务，主要提供保存、读取、删除得功能。
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


    /**
     * 读取文件
     * @param devicePath    设备上保存文件的Path
     * @return              返回输入流
     */
    InputStream read(String devicePath);

    /**
     * 删除文件
     * @param devicePath    设备上保存文件的Path
     * @return              是否删除成功
     */
    boolean remove(String devicePath);

    /**
     * 是否存在文件
     * @param devicePath    设备上保存文件的Path
     * @return              是否存在设备中
     */
    boolean exists(String devicePath);

    /**
     * 服务是否是可用的状态
     * @return  服务是否可用
     */
    boolean isAvailable();
}
