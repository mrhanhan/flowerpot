package com.flowerpot.common.enums;

import com.flowerpot.common.KeyDescProvider;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * EffectiveEnum
 *
 * @author Mrhan
 * @date 2021/3/19 14:59
 */
@RequiredArgsConstructor
@Getter
public enum EffectiveEnum implements KeyDescProvider {

    /**
     * 有效
     */
    EFFECTIVE(1, "有效"),
    INVALID(0, "无效")
    ;

    private final Integer key;
    private final String desc;
}
