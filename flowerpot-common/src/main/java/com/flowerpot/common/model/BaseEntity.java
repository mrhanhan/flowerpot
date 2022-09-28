package com.flowerpot.common.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 所有是实体类的基类
 * @author Mrhan
 * @date 2021/2/24 19:32
 */
@Data
public class BaseEntity implements Serializable {

    /**
     * ID
     */
    @TableField(fill = FieldFill.INSERT)
    @TableId
    private Long id;

    /**
     * 创建者
     */
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    @JsonIgnore
    private Long createBy;

    /**
     * 更改者
     */
    @TableField(value = "modify_by", fill = FieldFill.INSERT_UPDATE)
    @JsonIgnore
    private Long modifyBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 更改时间
     */
    @TableField(value = "modify_time", fill = FieldFill.INSERT_UPDATE)
    private Date modifyTime;

    /**
     * 记录是否是有效的
     */
    @TableField(fill = FieldFill.INSERT)
    @JsonIgnore
    private Integer effective;
}
