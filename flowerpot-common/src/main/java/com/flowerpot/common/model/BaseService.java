package com.flowerpot.common.model;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * BaseService
 *
 * @author Mrhan
 * @date 2021/3/18 22:43
 */
public interface BaseService<T extends BaseEntity> extends IService<T> {
}
