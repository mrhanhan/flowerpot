package com.flowerpot.common.utils.collection;

import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * CollectionUtil
 *
 * @author Mrhan
 * @date 2021/6/7 15:57
 */
@UtilityClass
public class CollectionUtil {

    /**
     * 集合转换为Map
     * @param data                  数据集合
     * @param getKeyFunction        获取Key的函数
     * @param <K>                   Key类型
     * @param <T>                   Value类型
     * @return                      返回Map
     */
    public <K, T> Map<K, T> toMap (Collection<T> data, Function<T, K> getKeyFunction) {
        return data.stream().collect(Collectors.toMap(getKeyFunction, Function.identity()));
    }

    /**
     * 集合转换为Map
     * @param data                  数据集合
     * @param getKeyFunction        获取Key的函数
     * @param <K>                   Key类型
     * @param <T>                   Value类型
     * @return                      返回Map
     */
    public <K, T> Map<K, List<T>> toListMap (Collection<T> data, Function<T, K> getKeyFunction) {
        return data.stream().collect(Collectors.groupingBy(getKeyFunction, Collectors.toList()));
    }

}
