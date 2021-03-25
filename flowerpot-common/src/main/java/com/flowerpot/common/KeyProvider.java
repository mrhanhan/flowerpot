package com.flowerpot.common;

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
}
