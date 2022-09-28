package com.flowerpot.storage.dto;

import com.flowerpot.common.utils.config.ConfigTemplate;
import com.flowerpot.common.utils.config.annotation.Input;
import lombok.Data;

/**
 * LocalStorageProperties
 *
 * @author Mrhan
 * @date 2021/5/24 17:20
 */
@Data
public class LocalStorageProperties implements ConfigTemplate {

    @Input(label = "根目录", placeholder = "文件存储的根目录", required = true)
    private String baseDir;
}
