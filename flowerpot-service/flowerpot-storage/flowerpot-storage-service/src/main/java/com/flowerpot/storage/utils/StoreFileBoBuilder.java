package com.flowerpot.storage.utils;

import com.flowerpot.storage.dto.StoreFileBo;
import com.flowerpot.storage.enums.StoreDeviceSupplierEnum;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

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
    @SneakyThrows
    public StoreFileBoBuilder file(File file) {
        String fullName = file.getName();
        storeFileBo.setSource(new FileInputStream(file));
        storeFileBo.setSize(file.length());;
        return fileName(fullName);
    }

    /**
     * Source
     * @param source    数据源
     * @param fillName  文件名称
     * @param size      文件大小
     * @return          StoreFileBoBuilder
     */
    public StoreFileBoBuilder source(InputStream source, String fillName, long size) {
        storeFileBo.setSource(source);
        storeFileBo.setSize(size);;
        return fileName(fillName);
    }


    /**
     * 设置文件全名称
     * @param fullName  fullName
     * @return          StoreFileBoBuilder
     */
    public StoreFileBoBuilder fileName(String fullName) {
        String[] fullNameSegment = fullName.split("\\.");
        storeFileBo.setFullName(fullName);
        storeFileBo.setSuffix(fullNameSegment.length > 1 ? ("." + fullNameSegment[1]) : "");
        storeFileBo.setName(fullNameSegment[0]);
        return this;
    }


    /**
     * 保存
     * @param dir   目录
     * @param name  名称
     * @return  StoreFileBoBuilder
     */
    public StoreFileBoBuilder save(String dir, String name) {
        storeFileBo.setPath(dir);
        storeFileBo.setSaveName(name + "." + storeFileBo.getSuffix());
        storeFileBo.setDevicePath((dir + "/" + storeFileBo.getSaveName()).replaceAll("//", "/"));
        return this;
    }
}
