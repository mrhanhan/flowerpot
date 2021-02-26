package com.flowerapot.generator.universal.mysql.model;

import com.flowerapot.generator.universal.common.DataTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * TableColumn
 *
 * @author Mrhan
 * @date 2021/2/27 0:11
 */
@Data
@Accessors
public class TableColumn {

    /**
     * 名称
     */
    private String name;

    /**
     * 数据类型
     */
    private DataTypeEnum type;

    /**
     * 长度
     */
    private String length;

    /**
     * 默认值
     */
    private String defaultValue;

    /**
     * 不能为空
     */
    private boolean canNotNull;

    /**
     * 表信息
     */
    private String comment;
}
