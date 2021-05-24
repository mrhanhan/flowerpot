package com.flowerpot.common.utils;

import com.flowerpot.common.KeyDescProvider;
import com.flowerpot.common.KeyProvider;
import lombok.experimental.UtilityClass;

import java.util.Objects;

/**
 * EnumUtils
 *
 * @author Mrhan
 * @date 2021/3/25 21:16
 */
@UtilityClass
public class EnumUtil {

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

    /**
     * 根据Key 获取相同key的对象信息
     * @param values    匹配数组
     * @param key       Key
     * @param <V>       Key类型泛型
     * @param <T>       匹配数据类型泛型
     * @return          返回匹配中的对象
     */
    public <V, T extends KeyProvider<V>> T getByKey(T[] values, V key) {
        for (T value : values) {
            if (Objects.equals(value.getKey(), key)) {
                return value;
            }
        }
        return null;
    }

}
