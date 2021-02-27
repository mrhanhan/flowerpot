package com.flowerapot.generator.universal.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * DataType
 * 数据类型枚举
 * @author Mrhan
 * @date 2021/2/26 10:34
 */
@RequiredArgsConstructor
@Getter
public enum DataTypeEnum {

    /**
     * 整形
     */
    INT("int", "Integer"),
    /**
     *
     */
    TINYINT("tinyint", "Integer"),
    /**
     * 长整形
     */
    LONG("bigint", "Long"),
    /**
     * 小数
     */
    DECIMAL("decimal", "BigDecimal"),
    /**
     * VARCHAR
     */
    VARCHAR("varchar", "String"),
    /**
     * Text
     */
    TEXT("text", "String"),
    /**
     * Date
     */
    DATE("datetime", "Date");

    private final String sqlType;

    private final String javaType;
}
