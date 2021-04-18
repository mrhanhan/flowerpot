package com.flowerpot.service.storage.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.flowerpot.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author Mrhan
 * @date 2021-04-18 20:34
 */
@TableName("st_store_file_attribute")
@Data
@EqualsAndHashCode(callSuper = true)
public class StoreFileAttribute extends BaseEntity implements Serializable{

    /**
     * 文件ID
     */
    @TableField("file_id")
    private Long fileId;
    /**
     * 关联的ID 冗余数据
     */
    @TableField("relation_id")
    private Long relationId;
    /**
     * 关联的类型 StoreFileRelationTypeEnum 冗余数据
     */
    @TableField("relation_type")
    private Integer relationType;
    /**
     * 属性名称
     */
    private String name;
    /**
     * 属性值
     */
    private String value;
}
