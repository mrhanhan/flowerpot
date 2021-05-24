package com.flowerpot.common.utils.config;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.flowerpot.common.utils.config.model.AppConfig;
import com.flowerpot.common.utils.config.model.ConfigField;

import java.util.List;

public class ConfigResolveTest{
    public static void main(String[] args) {
        List<ConfigField> resolve = ConfigResolveUtil.resolve(AppConfig.class);
        System.out.println(JSONObject.toJSONString(resolve, SerializerFeature.PrettyFormat));
    }

}