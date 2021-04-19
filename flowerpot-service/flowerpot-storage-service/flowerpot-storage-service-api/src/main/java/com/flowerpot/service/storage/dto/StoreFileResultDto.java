package com.flowerpot.service.storage.dto;

import lombok.Data;

import java.io.InputStream;
import java.util.function.Supplier;

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
     * 数据源供应商
     */
    public Supplier<InputStream> sourceSupplier;
}
