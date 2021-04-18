package com.flowerpot.service.storage.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.flowerpot.common.model.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author Mrhan
 * @date 2021-04-18 20:34
 */
@TableName("st_store_device")
@Data
@EqualsAndHashCode(callSuper = true)
public class StoreDevice extends BaseEntity implements Serializable{

    /**
     * 配置Code StoreDeviceEnum
     */
    private String code;
    /**
     * 设备名称
     */
    private String name;
    /**
     * 设备状态， StoreDeviceStatusEum
     */
    private Integer status;
    /**
     * 存储设备供应商类型 StoreDeviceSupplierEnum
     */
    private String supplier;
    /**
     * 对应配置的JSON或者 Properties
     */
    private String config;
}
