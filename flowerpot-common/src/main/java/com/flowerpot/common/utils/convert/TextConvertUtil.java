package com.flowerpot.common.utils.convert;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.experimental.UtilityClass;

import java.lang.reflect.Type;

/**
 * TextUtil
 *
 * @author Mrhan
 * @date 2021/7/24 20:00
 */
@UtilityClass
public class TextConvertUtil {
    /**
     * 转换为JSON 字符串
     * @param obj   转换为JSON字符串
     * @return 转换为JSON字符串
     */
    public String toJsonText(Object obj) {
        return JSON.toJSONString(obj);
    }

    /**
     * JSON 转换为Java对象
     * @param json  JSON字符串
     * @param type  对象类型
     * @param <T>   对象的泛型
     * @return  返回Java字符串
     */
    public <T> T toObject(String json, Type type) {
        return JSONObject.parseObject(json).toJavaObject(type);
    }
    /**
     * JSON 转换为Java对象
     * @param json  JSON字符串
     * @param type  对象类型
     * @param <T>   对象的泛型
     * @return  返回Java字符串
     */
    public <T> T toObject(String json, Class<T> type) {
        return JSONObject.parseObject(json).toJavaObject(type);
    }
}
