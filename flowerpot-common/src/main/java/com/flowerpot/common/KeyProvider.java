package com.flowerpot.common;

import java.util.Objects;

/**
 * KeyProvider
 *
 * @author Mrhan
 * @date 2021/3/25 21:12
 */
public interface KeyProvider<T> {

    /**
     * 获取Key
     * @return  返回Key
     */
    T getKey();

    /**
     * Key 是否一致
     * @param key   Key
     * @return      返回情况
     */
    default boolean keyEquals(T key) {
        return Objects.equals(key, getKey());
    }

    /**
     * Key 是否一致
     * @param key   Key
     * @return      返回情况
     */
    default boolean keyEquals(KeyProvider<T> key) {
        return Objects.equals(key.getKey(), getKey());
    }

}
