package com.flowerpot.common.utils;

import lombok.experimental.UtilityClass;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * ConvertUtils
 *
 * @author Mrhan
 * @date 2021/3/23 17:38
 */
@UtilityClass
public class ConvertUtils {

    /**
     * 创建新的并且创建对象
     * @param source        源对象
     * @param targetType    目标类型
     * @param <T>           目录类型泛型
     * @return              返回复制后的对象
     */
    public  <T> T convert(Object source, Class<T> targetType) {
        T data = BeanUtils.instantiateClass(targetType);
        BeanUtils.copyProperties(source, data);
        return data;
    }

    /**
     * List 转换为 Map
     * @param list          源类型Map
     * @param targetType    目标类型
     * @param keyFunc       获取Key的方式
     * @param <K>           Map Key的类型泛型
     * @param <T>           List泛型
     * @param <C>           Map Value的类型泛型
     * @return              返回Map
     */
    public <K, T, C> Map<K, C> mapConvert(List<T> list, Class<C> targetType, Function<C, K> keyFunc) {
        List<C> targetList = list.stream().map(t-> convert(t, targetType)).collect(Collectors.toList());
        return targetList.stream().collect(Collectors.toMap(keyFunc, Function.identity()));
    }
}
