package com.flowerpot.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * PageResult
 *
 * @author Mrhan
 * @date 2021/2/24 10:31
 */
@ApiModel
public class PageResult<T> extends Result<PageResult.Page<T>> {
    @ApiModel
    @Data
    public static class Page<E> {
        @ApiModelProperty("总记录条数")
        private long total;
        @ApiModelProperty("返回的数据")
        private List<E> list;
    }

    /**
     * 创建PageResult
     * @param total     总记录条数
     * @param list      数据
     * @param <T>       分页类型
     * @return          返回记录信息
     */
    public static <T> PageResult<T> create(long total, List<T> list) {
        PageResult<T> pageResult = new PageResult<>();
        // 分页对象
        Page<T> page = new Page<>();
        page.setTotal(total);
        page.setList(list);

        pageResult.setData(page);
        return pageResult;
    }
}
