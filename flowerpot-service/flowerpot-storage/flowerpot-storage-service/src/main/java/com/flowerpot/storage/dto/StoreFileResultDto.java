package com.flowerpot.storage.dto;

import com.flowerpot.storage.entity.StoreFile;
import com.flowerpot.storage.utils.StoreFileFactory;
import lombok.Data;

/**
 * StoreFileResultBo
 * 存储文件结果Bo
 * @author Mrhan
 * @date 2021/4/19 9:39
 */
@Data
public class StoreFileResultDto {
    /**
     * 存储文件的类型
     */
    private StoreFileBo storeFile;
    /**
     * 访问URL
     */
    private String accessUrl;
    /**
     * 保存后的设备路径
     */
    private String devicePath;

    /**
     * 数据源供应商
     */
    public StoreFile file;

    public StoreFileResultDto() {
    }

    public StoreFileResultDto(StoreFileBo storeFile, String accessUrl) {
        this.storeFile = storeFile;
        this.accessUrl = accessUrl;
        this.file = StoreFileFactory.of(storeFile);
        this.file.setAccessUrl(accessUrl);
    }
}

