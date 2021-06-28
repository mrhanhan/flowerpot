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
    @ApiModelProperty(value = "查询的页", required = true)
    private int current;

    /**
     * 分页大小
     */
    @ApiModelProperty(value = "分页大小", required = true)
    private int pageSize;

    @ApiModelProperty("搜索关键字")
    private String searchWord;

    
    public <T> Page<T> toPage() {
        return new Page<>(current, pageSize);
    }
}
