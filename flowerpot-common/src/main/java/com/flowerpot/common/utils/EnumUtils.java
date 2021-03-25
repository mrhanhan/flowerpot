package com.flowerpot.common.utils;

import com.flowerpot.common.KeyDescProvider;
import lombok.experimental.UtilityClass;

import java.util.Objects;

/**
 * EnumUtils
 *
 * @author Mrhan
 * @date 2021/3/25 21:16
 */
@UtilityClass
public class EnumUtils {

    /**
     * 获取对应Key的描述信息
     * @param values        values
     * @param key           查找的Key
     * @return              返回对应的value
     */
    public String getDesc(KeyDescProvider[] values, Integer key) {
        for (KeyDescProvider value : values) {
            if (Objects.equals(value.getKey(), key)) {
                return value.getDesc();
            }
        }
        return null;
    }


}
