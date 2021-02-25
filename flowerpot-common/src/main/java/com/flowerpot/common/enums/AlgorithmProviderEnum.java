package com.flowerpot.common.enums;

import com.auth0.jwt.algorithms.Algorithm;
import com.flowerpot.common.utils.token.AlgorithmProvider;
import com.flowerpot.common.utils.token.AlgorithmProviderManager;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * AlgorithmProviderEnum
 *
 * @author Mrhan
 * @date 2021/2/25 10:39
 */
@Getter
public enum  AlgorithmProviderEnum implements AlgorithmProvider {
    /**
     * 通用加密
     */
    COMMON(Algorithm.HMAC256("WOSHINIBABA"))
    ;

    AlgorithmProviderEnum(Algorithm algorithm) {
        this.algorithm = algorithm;
        AlgorithmProviderManager.register(name(), this, false);
    }

    private final Algorithm algorithm;
}
