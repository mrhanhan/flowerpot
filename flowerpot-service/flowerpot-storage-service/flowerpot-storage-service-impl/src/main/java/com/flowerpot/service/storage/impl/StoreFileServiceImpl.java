package com.flowerpot.service.storage.impl;


import com.flowerpot.common.model.BaseServiceImpl;
import com.flowerpot.service.storage.mapper.StoreFileMapper;
import com.flowerpot.service.storage.entity.StoreFile;
import com.flowerpot.service.storage.service.StoreFileAttributeService;
import com.flowerpot.service.storage.service.StoreFileService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *@author Mrhan
 *@date 2021-04-18 20:40
 */
@Service
public class StoreFileServiceImpl extends BaseServiceImpl<StoreFile, StoreFileMapper> implements StoreFileService {

    @Resource
    private StoreFileAttributeService storeFileAttributeService;

}
