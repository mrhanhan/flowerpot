package com.flowerpot.common;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * PageRequest
 *
 * @author Mrhan
 * @date 2021/4/2 11:33
 */
@Data
@ApiModel
public class PageRequest {

    /**
     * 当前页
     */
    @ApiModelProperty("查询的页")
    private int current;

    /**
     * 分页大小
     */
    @ApiModelProperty("分页大小")
    private int pageSize;

    
    public <T> Page<T> toPage() {
        return new Page<>(current, pageSize);
    }
}
