package com.flowerpot.service.storage.utils;

import com.flowerpot.service.storage.dto.StoreFileBo;
import com.flowerpot.service.storage.enums.StoreDeviceSupplierEnum;

import java.io.File;

/**
 * StoreFileBoFactory
 *
 * @author Mrhan
 * @date 2021/4/19 17:50
 */
public class StoreFileBoBuilder {
    /**
     * Bo
     */
    private final StoreFileBo storeFileBo;

    /**
     * 静态方法
     */

    private static StoreFileBoBuilder create(StoreDeviceSupplierEnum storeDeviceSupplierEnum) {
        StoreFileBoBuilder builder = new StoreFileBoBuilder();
        builder.storeFileBo.setDeviceEnum(storeDeviceSupplierEnum);
        return builder;
    }

    /**
     * StoreFileBoBuilder
     */
    public StoreFileBoBuilder() {
        storeFileBo = new StoreFileBo();
    }
    public StoreFileBo build() {
        return storeFileBo;
    }

    /**
     * File
     * @param file  文件
     * @return      文件类型
     */
    public StoreFileBoBuilder file(File file) {
        String fullName = file.getName();
        String[] fullNameSegment = fullName.split("\\.");
        storeFileBo.setFullName(fullName);
        storeFileBo.setSuffix(fullNameSegment.length > 1 ? ("." + fullNameSegment[1]) : "");
        storeFileBo.setName(fullNameSegment[0]);
        return this;
    }


}
