package com.flowerpot.common.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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
    private Long id;
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 更改时间
     */
    @TableField(value = "modify_time", fill = FieldFill.INSERT)
    private Date modifyTime;

}
