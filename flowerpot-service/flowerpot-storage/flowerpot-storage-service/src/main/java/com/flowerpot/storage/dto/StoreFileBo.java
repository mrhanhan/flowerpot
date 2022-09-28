package com.flowerpot.storage.dto;

import com.flowerpot.storage.enums.StoreDeviceSupplierEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.InputStream;

/**
 * StoreFileBo
 *
 * @author Mrhan
 * @date 2021/4/19 9:33
 */
@Data
@Accessors
public class StoreFileBo {
    /**
     * 文件名称
     */
    private String name;
    /**
     * 后缀名
     */
    private String suffix;
    /**
     * 全文件名称
     */
    private String fullName;
    /**
     * 文件流
     */
    private InputStream source;
    /**
     * 保存的文件名
     */
    private String saveName;
    /**
     * 大小
     */
    private long size;
    /**
     * 设备枚举
     */
    private StoreDeviceSupplierEnum deviceEnum;
    /**
     * 保存目录
     */
    private String path;
    /**
     * ContentType
     */
    private String contentType;
    /**
     * 设备路径
     */
    private String devicePath;
}
