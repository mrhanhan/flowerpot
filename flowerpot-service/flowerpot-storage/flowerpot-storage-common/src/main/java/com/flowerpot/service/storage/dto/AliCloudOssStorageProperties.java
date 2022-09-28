package com.flowerpot.storage.dto;

import com.flowerpot.common.utils.config.ConfigTemplate;
import com.flowerpot.common.utils.config.annotation.Input;
import lombok.Data;

/**
 * AliCloudOssStorageProperties
 *
 * @author Mrhan
 * @date 2021/5/24 17:19
 */
@Data
public class AliCloudOssStorageProperties implements ConfigTemplate {

    @Input(label = "AccessKeyId", placeholder = "阿里云OSS AccessKeyId", required = true)
    private String accessKeyId;

    @Input(label = "SecretAccessKey", placeholder = "阿里云OSS SecretAccessKey", required = true)
    private String secretAccessKey;

    @Input(label = "Endpoint", placeholder = "阿里云OSS Endpoint")
    private String endpoint;

    @Input(label = "目录", placeholder = "默认根目录")
    private String baseKey;
}
