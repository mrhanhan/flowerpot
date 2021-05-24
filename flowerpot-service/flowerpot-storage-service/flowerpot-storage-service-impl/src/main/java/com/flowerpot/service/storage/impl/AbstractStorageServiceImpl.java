package com.flowerpot.service.storage.impl;

import com.flowerpot.service.storage.service.StorageService;
import lombok.AccessLevel;
import lombok.Setter;

/**
 * AbstractStorageServiceImpl
 *
 * @author Mrhan
 * @date 2021/5/24 15:22
 */
public abstract class AbstractStorageServiceImpl implements StorageService {

    @Setter(AccessLevel.PROTECTED)
    private boolean available;

    @Override
    public boolean isAvailable() {
        return available;
    }
}
