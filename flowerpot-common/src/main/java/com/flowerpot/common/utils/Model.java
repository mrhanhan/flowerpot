package com.flowerpot.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;

/**
 * Model
 *
 * @author Mrhan
 * @date 2021/5/29 15:35
 */
public class Model extends HashMap<String, Object> {
    public Model() {
    }

    /**
     * 添加一个属性
     * @param name  property
     * @param val   value
     * @return   Model
     */
    public Model add(String name, Object val) {
        put(name, val);
        return this;
    }

    /**
     * 属性来源
     * @param object    原本的数据
     * @return          返回Model
     */
    public Model from(Object object) {
        if (object instanceof Model) {
            super.putAll((Model)object);
            return this;
        }
        JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(object));
        super.putAll(jsonObject);
        return this;
    }
    /**
     * 获取属性值
     * @param name  属性名称
     * @param <T>   值泛型
     * @return      返回属性值
     */
    public <T> T get(String name) {
        if (containsKey(name)) {
            return (T) super.get(name);
        }
        return null;
    }

    /**
     * 创建一个Model
     * @param name  property
     * @param val   value
     * @return   Model
     */
    public static Model of(String name, Object val) {
        return new Model().add(name, val);
    }

    /**
     * 创建一个Model
     * @param model  model
     * @return   Model
     */
    public static Model source(Object model) {
        return new Model().from(model);
    }



}
