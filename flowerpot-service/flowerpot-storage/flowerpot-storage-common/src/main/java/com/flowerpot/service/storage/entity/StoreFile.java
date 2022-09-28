package com.flowerpot.storage.entity;

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
@TableName("st_store_file")
@Data
@EqualsAndHashCode(callSuper = true)
public class StoreFile extends BaseEntity implements Serializable{

    /**
     * 存储资源的设备ID
     */
    @TableField("device_id")
    private Long deviceId;
    /**
     * 关联的ID
     */
    @TableField("relation_id")
    private Long relationId;
    /**
     * 关联的类型 StoreFileRelationTypeEnum
     */
    @TableField("relation_type")
    private Integer relationType;
    /**
     * 文件名称， 不包含后缀名
     */
    private String name;
    /**
     * 文件后缀名
     */
    private String suffix;
    /**
     * 文件大小
     */
    private Long size;
    /**
     * 文件在设备上存储的位置
     */
    @TableField("device_path")
    private String devicePath;
    /**
     * 访问URL
     */
    @TableField("access_url")
    private String accessUrl;
}
