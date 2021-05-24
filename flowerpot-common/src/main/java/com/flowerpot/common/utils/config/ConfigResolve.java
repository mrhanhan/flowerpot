package com.flowerpot.common.utils.config;

import com.flowerpot.common.utils.config.annotation.Checkbox;
import com.flowerpot.common.utils.config.annotation.CheckboxGroup;
import com.flowerpot.common.utils.config.annotation.Config;
import com.flowerpot.common.utils.config.annotation.Radio;
import com.flowerpot.common.utils.config.annotation.RadioGroup;
import com.flowerpot.common.utils.config.annotation.Table;
import com.flowerpot.common.utils.config.annotation.VueComponent;
import com.flowerpot.common.utils.config.model.ConfigField;
import com.flowerpot.common.utils.config.model.KeyValue;
import lombok.SneakyThrows;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ConfigResolve
 * 配置解析
 * @author Mrhan
 * @date 2021/5/24 15:55
 */
public class ConfigResolve {
    /**
     * 需要解析的Bean类型
     */
    private final Class<?> beanClass;
    /**
     * 解析出来的配置列表
     */
    private List<ConfigField> fieldList;

    public ConfigResolve(Class<?> beanClass) {
        this.beanClass = beanClass;
        fieldList = new ArrayList<>();
    }

    /**
     * 解析
     */
    public List<ConfigField> resolve() {
        fieldList.clear();
        resolve(beanClass, "", fieldList);
        return fieldList;
    }

    /**
     * 解析
     * @param beanClass 需要解析的Bean类型
     * @param scope     字段作用域
     * @param fieldList 字段列表
     */
    @SneakyThrows
    private void resolve(Class<?> beanClass, String scope, List<ConfigField> fieldList) {
        Field[] fields = beanClass.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            Annotation configAnnotation = null;
            Config config = null;
            for (Annotation annotation : annotations) {
                config = annotation.annotationType().getAnnotation(Config.class);
                if (config != null) {
                    configAnnotation = annotation;
                    break;
                }
            }
            if (config == null) {
                // 解析子配置
                if (ConfigTemplate.class.isAssignableFrom(field.getType())) {
                    resolve(field.getType(), scope + (scope.isEmpty() ? "" : ".") + field.getName(), fieldList);
                }
                continue;
            }
            ConfigField configField = new ConfigField();
            configField.setAttrMap(new HashMap<>());
            configField.setTag(config.tag());
            configField.setScope(scope);
            configField.setField(field.getName());
            // 设置label
            Class<? extends Annotation> aClass = configAnnotation.annotationType();
            Method label = aClass.getMethod("label");
            configField.setLabel(label.invoke(configAnnotation).toString());
            // 解析
            resolveAnnotation(config, configAnnotation, configField, scope, field);
        }
    }

    /**
     * 解析枚举
     */
    @SneakyThrows
    private void resolveAnnotation(Config config, Annotation configAnnotation, ConfigField configField, String scope, Field field) {
        if (configAnnotation instanceof Table) {
            // Table
            Class<?> type = field.getType();
            if (ConfigTemplate.class.isAssignableFrom(type)) {
                List<ConfigField> children = new ArrayList<>();
                resolve(type, "", children);
                configField.setChildren(children);
            }
        } else if (configAnnotation instanceof CheckboxGroup) {
            Checkbox[] options = ((CheckboxGroup) configAnnotation).options();
            configField.getAttrMap().put("options", Stream.of(options).map(t -> new KeyValue(t.label(), t.value())).collect(Collectors.toList()));
        } else if (configAnnotation instanceof RadioGroup) {
            Radio[] options = ((RadioGroup) configAnnotation).options();
            configField.getAttrMap().put("options", Stream.of(options).map(t -> new KeyValue(t.label(), t.value())).collect(Collectors.toList()));
        } else if (configAnnotation instanceof VueComponent) {
            configField.setTag(((VueComponent) configAnnotation).tag());
        }
        // 配置属性
        Method[] methods = configAnnotation.annotationType().getMethods();
        for (Method method : methods) {
            configField.getAttrMap().put(method.getName(), method.invoke(configAnnotation));
        }
    }
}
