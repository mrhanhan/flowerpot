package com.flowerpot.common.utils.template;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * TemplateResolve
 * 模板解析器
 * @author Mrhan
 * @date 2021/5/25 11:42
 */
@FunctionalInterface
public interface TemplateResolve {
    /**
     * 解析模板
     * @param templateName  templateName
     * @param parameter     Parameter
     * @return              模板解析
     */
    String resolve(String templateName, Map<String, Object> parameter);

    /**
     * 解析
     * @param templateName  模板名称
     * @param model         数据对象
     * @return              返回解析后的模板数据
     */
    default String resolve(String templateName, Object model) {
        return resolve(templateName, JSONObject.parseObject(JSON.toJSONString(model)));
    }
}
