package com.flowerpot.common.model;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.flowerpot.common.utils.collection.CollectionUtil;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * BaseServiceImpl
 *
 * @author Mrhan
 * @date 2021/3/18 22:44
 */
public class BaseServiceImpl<T extends BaseEntity, M extends BaseMapper<T>> extends ServiceImpl<M, T> implements BaseService<T> {
    @Override
    public Map<Long, T> map() {
        return map(null);
    }

    @Override
    public Map<Long, T> mapByIds(Collection<Long> idBatch) {
        LambdaQueryWrapper<T> wrapper = Wrappers.lambdaQuery();
        wrapper.in(BaseEntity::getId, idBatch);
        return map(wrapper);
    }

    @Override
    public Map<Long, T> map(Wrapper<T> wrapper) {
        return CollectionUtil.toMap(super.list(wrapper), T::getId);
    }

    @Override
    public <Key> Map<Key, List<T>> listMap(Function<T, Key> getKeyFunction) {
        return listMap(null, getKeyFunction);
    }

    @Override
    public <Key> Map<Key, List<T>> listMap(Wrapper<T> wrapper, Function<T, Key> getKeyFunction) {
        return CollectionUtil.toListMap(super.list(wrapper), getKeyFunction);
    }

    @Override
    protected Class<T> currentModelClass() {
        return (Class<T>) ReflectionKit.getSuperClassGenericType(getClass(), 0);
    }
}
