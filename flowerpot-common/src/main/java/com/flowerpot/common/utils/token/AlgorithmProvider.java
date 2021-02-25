package com.flowerpot.common.utils.token;

import com.auth0.jwt.algorithms.Algorithm;

/**
 * AlgorithmProvider
 * 算法提供者
 * @author Mrhan
 * @date 2021/2/25 10:25
 */
@FunctionalInterface
public interface AlgorithmProvider {

    /**
     * 获取算法
     * @return  Algorithm
     */
    Algorithm getAlgorithm();

    /**
     * 供应商名称
     * @return      返回供应者名称
     */
    default String name() {
        return getAlgorithm().getName();
    }

}
