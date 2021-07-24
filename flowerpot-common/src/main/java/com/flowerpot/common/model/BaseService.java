package com.flowerpot.common.model;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * BaseService
 *
 * @author Mrhan
 * @date 2021/3/18 22:43
 */
public interface BaseService<T extends BaseEntity> extends IService<T> {

    /**
     * 获取实体的IDMap信息
     * @return  Map信息
     */
    Map<Long, T> map();

    /**
     * 查询指定IP的Map
     * @param idBatch   ID集合
     * @return          返回查询这些IP的Map
     */
    Map<Long, T> mapByIds(Collection<Long> idBatch);

    /**
     * Wrapper 转换为Map
     * @param wrapper Wrapper
     * @return 返回数据转换后的Map
     */
    Map<Long, T> map(Wrapper<T> wrapper);

    /**
     * 查询List Map
     * @param getKeyFunction    获取Key的方法
     * @param <Key>             Key的泛型
     * @return                  返回ListWrapper
     */
    <Key> Map<Key, List<T>> listMap(Function<T, Key> getKeyFunction);


    /**
     * 查询List Map
     * @param wrapper           查询Wrapper条件
     * @param getKeyFunction    获取Key的方法
     * @param <Key>             Key的泛型
     * @return                  返回ListWrapper
     */
    <Key> Map<Key, List<T>> listMap(Wrapper<T> wrapper, Function<T, Key> getKeyFunction);
}
