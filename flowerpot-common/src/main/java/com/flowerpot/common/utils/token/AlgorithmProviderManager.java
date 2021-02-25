package com.flowerpot.common.utils.token;

import lombok.experimental.UtilityClass;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * AlgorithmProviderManager
 *
 * @author Mrhan
 * @date 2021/2/25 11:23
 */
@UtilityClass
public final class AlgorithmProviderManager {

    private static final Map<String, AlgorithmProvider> ALL_ALGORITHM_MAP = new HashMap<>();
    /**
     * 临时加密提供者
     */
    private static final Map<String, AlgorithmProvider> TEMP_ALGORITHM_MAP = new ConcurrentHashMap<>();
    /**
     * 根据名称获取加密的方式的提供者
     * @param name          name
     * @return              return
     */
    public AlgorithmProvider findByName(String name) {
        if (name == null) {
            return null;
        }
        if (TEMP_ALGORITHM_MAP.containsKey(name)) {
            AlgorithmProvider algorithmProvider = TEMP_ALGORITHM_MAP.get(name);
            TEMP_ALGORITHM_MAP.remove(name);
            return algorithmProvider;
        }
        return ALL_ALGORITHM_MAP.get(name);
    }

    /**
     * 注册加密方式提供者
     * @param name                  Name
     * @param algorithmProvider     Name
     * @param isTemp                是否是临时的加密提供
     */
    public void register(String name, AlgorithmProvider algorithmProvider, boolean isTemp) {
        if (isTemp) {
            TEMP_ALGORITHM_MAP.put(name, algorithmProvider);
        } else {
            ALL_ALGORITHM_MAP.put(name, algorithmProvider);
        }
    }
}
