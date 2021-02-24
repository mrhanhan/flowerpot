package com.flowerpot.common.enums;

import com.flowerpot.common.ResultEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * CommonResultEnum
 * 通用响应枚举
 * @author Mrhan
 * @date 2021/2/24 10:38
 */
@Getter
@RequiredArgsConstructor
public enum CommonResultEnum implements ResultEnum {
    /**
     * 成功
     */
    SUCCESS(200, "success"),
    /**
     * 错误
     */
    ERROR(500, "error"),

    ;
    private final int code;
    private final String message;
}
