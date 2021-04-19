package com.flowerpot.service.storage.dto;

import com.flowerpot.service.storage.enums.StoreDeviceSupplierEnum;
import com.flowerpot.service.storage.enums.StoreFileRelationType;
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
     * 存储关联类型
     */
    private StoreFileRelationType relationType;
    /**
     * RelationId
     */
    private Long relationId;
}
