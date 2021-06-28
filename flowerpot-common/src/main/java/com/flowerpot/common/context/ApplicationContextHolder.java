package com.flowerpot.common.context;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.UtilityClass;
import org.springframework.context.ApplicationContext;

import java.util.Objects;

/**
 * ApplicationContextHolder
 * ApplicationContextHolder
 * @author Mrhan
 * @date 2021/6/27 19:53
 */
@UtilityClass
public class ApplicationContextHolder {

    @Setter
    @Getter
    private ApplicationContext context;

    /**
     * 获取Bean信息
     * @param cls   cls
     * @param <T>   Bean类型
     * @return      返回Bean
     */
    public <T> T getBean(Class<T> cls) {
        return Objects.nonNull(context) ? context.getBean(cls) : null;
    }

    /**
     * 获取Bean信息
     * @param beanName   beanName
     * @param cls        bean 类型
     * @param <T>   Bean类型
     * @return      返回Bean
     */
    public <T> T getBean(String beanName, Class<T> cls) {
        return Objects.nonNull(context) ? context.getBean(beanName, cls) : null;
    }

}
