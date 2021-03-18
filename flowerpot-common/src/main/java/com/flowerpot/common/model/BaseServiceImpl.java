package com.flowerpot.common.model;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * BaseServiceImpl
 *
 * @author Mrhan
 * @date 2021/3/18 22:44
 */
public class BaseServiceImpl<T extends BaseEntity, M extends BaseMapper<T>> extends ServiceImpl<M, T> implements BaseService<T> {
}
