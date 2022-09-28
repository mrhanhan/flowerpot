package com.flowerpot.service.storage.utils;

import com.flowerpot.service.storage.dto.StoreFileBo;
import com.flowerpot.service.storage.entity.StoreFile;
import com.flowerpot.service.storage.entity.StoreFileAttribute;
import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * StoreFileFactory
 *
 * @author Mrhan
 * @date 2021/5/24 11:41
 */
@UtilityClass
public class StoreFileFactory {
    /**
     * 根据StoreFileBo 创建StoreFile
     * @param storeFileBo   StoreFileBo
     * @return  StoreFile
     */
    public StoreFile of(StoreFileBo storeFileBo) {
        StoreFile storeFile = new StoreFile();
        storeFile.setName(storeFileBo.getName());
        storeFile.setSuffix(storeFileBo.getSuffix());
        storeFile.setAccessUrl("");
        storeFile.setDevicePath(storeFile.getDevicePath());
        storeFile.setSize(storeFileBo.getSize());
        return storeFile;
    }

    /**
     * 构建出 文件属性
     * @param list  原StoreFileAttribute
     * @param file  File
     * @return      关联后StoreFileAttribute
     */
    public List<StoreFileAttribute> ofAttrList(List<StoreFileAttribute> list, StoreFile file) {
        if (CollectionUtils.isEmpty(list)) {return list;}
        return list.stream().map(t -> {
            t.setRelationType(file.getRelationType());
            t.setRelationId(file.getRelationId());
            t.setFileId(file.getId());
            return t;}).collect(Collectors.toList());
    }
}
