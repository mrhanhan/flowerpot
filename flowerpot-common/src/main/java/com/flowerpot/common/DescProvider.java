package com.flowerpot.common;

/**
 * ValueProvider
 *
 * @author Mrhan
 * @date 2021/3/25 21:13
 */
public interface DescProvider<T> {
    /**
     * 获取描述信息
     * @return  返回描述信息
     */
    T getDesc();
}
