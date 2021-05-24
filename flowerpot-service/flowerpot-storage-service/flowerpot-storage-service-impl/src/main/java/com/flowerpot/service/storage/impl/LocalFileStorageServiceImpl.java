package com.flowerpot.service.storage.impl;

import com.flowerpot.common.utils.IoUtils;
import com.flowerpot.service.storage.dto.StoreFileBo;
import com.flowerpot.service.storage.dto.StoreFileResultDto;
import com.flowerpot.service.storage.service.StorageService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * LocalFileStorageServiceImpl
 *
 * @author Mrhan
 * @date 2021/5/23 12:59
 */
@RequiredArgsConstructor
public class LocalFileStorageServiceImpl implements StorageService {
    /**
     * BathPath
     */
    private final String basePath;

    @SneakyThrows
    @Override
    public StoreFileResultDto save(StoreFileBo store) {
        String devicePath = store.getDevicePath();
        FileOutputStream outputStream = new FileOutputStream(devicePath);
        IoUtils.writeTo(store.getSource(), outputStream);
        outputStream.flush();
        outputStream.close();
        return new StoreFileResultDto(store, store.getDevicePath());
    }

    @SneakyThrows
    @Override
    public InputStream read(String devicePath) {
        return new FileInputStream(resolveAbsolutePath(devicePath));
    }

    @Override
    public boolean remove(String devicePath) {
        File file = new File(resolveAbsolutePath(devicePath));
        return file.delete();
    }

    @Override
    public boolean exists(String devicePath) {
        File file = new File(resolveAbsolutePath(devicePath));
        return file.exists() && file.isFile();
    }

    /**
     * 解对路径
     * @param devicePath 设备路径
     * @return           返回绝对路径
     */
    private String resolveAbsolutePath(String devicePath) {
        return (basePath + devicePath).replaceAll("//", "/");
    }
}
