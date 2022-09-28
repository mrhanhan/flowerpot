package com.flowerpot.service.storage.impl;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.flowerpot.service.storage.constant.MetadataConstant;
import com.flowerpot.service.storage.dto.StoreFileBo;
import com.flowerpot.service.storage.dto.StoreFileResultDto;
import com.flowerpot.service.storage.service.StorageService;
import org.apache.commons.lang3.StringUtils;

import java.io.InputStream;

/**
 * AliCloudOssStorageServiceImpl
 *
 * @author Mrhan
 * @date 2021/4/19 17:11
 */
public class AliCloudOssStorageServiceImpl extends AbstractStorageServiceImpl implements StorageService {

    /**
     * OSS 客户端
     */
    private final OSSClient client;

    private final String bucketName;
    /**
     * 目录
     */
    private final String baseKey;

    public AliCloudOssStorageServiceImpl(OSSClient client, String bucketName, String baseKey) {
        this.client = client;
        this.bucketName = bucketName;
        this.baseKey = baseKey;
        if (StringUtils.isEmpty(baseKey) || StringUtils.equals(baseKey, "/")) {
            baseKey = "";
        } else {
            baseKey = baseKey.replaceAll("^/", "");
            baseKey = baseKey.replaceAll("/$", "");
            baseKey += "/";
        }

    }

    @Override
    public StoreFileResultDto save(StoreFileBo store) {
        ObjectMetadata metadata = createSaveObjectMetadata(store);
        PutObjectRequest request = new PutObjectRequest(bucketName, baseKey  + store.getDevicePath(), store.getSource(), metadata);
        client.putObject(request);
        // 访问URL
        return new StoreFileResultDto(store, store.getDevicePath());
    }

    @Override
    public InputStream read(String devicePath) {
        OSSObject object = client.getObject(bucketName, baseKey + devicePath);
        return object.getObjectContent();
    }

    @Override
    public boolean remove(String devicePath) {
        client.deleteObject(bucketName, baseKey + devicePath);
        return true;
    }

    @Override
    public boolean exists(String devicePath) {
        return client.doesObjectExist(bucketName, baseKey + devicePath);
    }

    /**
     * 创建保存的文件名称 元数据
     * @param store     存储的文件对象
     * @return          返回 metadata
     */
    private ObjectMetadata createSaveObjectMetadata(StoreFileBo store) {
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentType(store.getContentType());
        metadata.setContentLength(store.getSize());
        metadata.addUserMetadata(MetadataConstant.FILE_ORIGIN_NAME_FILED, store.getFullName());
        metadata.addUserMetadata(MetadataConstant.FILE_SUFFIX_NAME_FILED, store.getSuffix());
        metadata.addUserMetadata(MetadataConstant.FILE_NAME_NAME_FILED, store.getName());
        return metadata;
    }
}
