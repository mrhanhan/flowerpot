package com.flowerpot.service.storage.impl;


import com.flowerpot.common.model.BaseServiceImpl;
import com.flowerpot.service.storage.dao.StoreFileMapper;
import com.flowerpot.service.storage.dto.StoreFileBo;
import com.flowerpot.service.storage.entity.StoreFile;
import com.flowerpot.service.storage.entity.StoreFileAttribute;
import com.flowerpot.service.storage.service.StoreFileAttributeService;
import com.flowerpot.service.storage.service.StoreFileService;
import com.flowerpot.service.storage.utils.StoreFileFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 *@author Mrhan
 *@date 2021-04-18 20:40
 */
@Service
public class StoreFileServiceImpl extends BaseServiceImpl<StoreFile, StoreFileMapper> implements StoreFileService {

    @Resource
    private StoreFileAttributeService storeFileAttributeService;

}