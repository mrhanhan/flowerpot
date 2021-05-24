package com.flowerpot.common.utils.config.model;

import lombok.Data;

/**
 * KeyValue
 *
 * @author Mrhan
 * @date 2021/5/24 16:12
 */
@Data
public class KeyValue {

    private String key;

    private String value;

    public KeyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }

}
