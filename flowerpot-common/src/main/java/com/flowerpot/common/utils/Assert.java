package com.flowerpot.common.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * Asset
 *
 * @author Mrhan
 * @date 2021/3/24 14:33
 */
@UtilityClass
public class Assert {

    /**
     * 不能未空
     * @param object            对象信息
     * @param message           返回错误消息
     */
    public void notNull(Object object, String message) {
        if (Objects.isNull(object)) {
            throw new AssetException(message);
        }
    }
    
    /**
     * 不能未空
     * @param object            对象信息
     * @param message           返回错误消息
     */
    public void notEmpty(String object, String message) {
        if (StringUtils.isEmpty(object)) {
            throw new AssetException(message);
        }
    }
    /**
     * 不一样
     * @param o1            对象信息
     * @param o2            对象信息
     * @param message           返回错误消息
     */
    public void notEquals(Object o1, Object o2, String message) {
        if (Objects.equals(o1, o2)) {
            throw new AssetException(message);
        }
    }


    /**
     * 是Ture
     * @param result 如果是False 则抛出异常
     * @param message   异常消息
     */
    public void isTrue(boolean result, String message) {
        if (!result) {
            throw new AssetException(message);
        }
    }


}
