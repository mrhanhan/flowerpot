package com.flowerpot.common.utils;

import lombok.experimental.UtilityClass;

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
