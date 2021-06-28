package com.flowerpot.admin.config;

import com.flowerpot.common.context.ApplicationContextHolder;
import com.flowerpot.common.utils.template.TemplateResolve;
import com.flowerpot.common.utils.template.ThymeleafTemplateResolve;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 * SystemConfig
 *
 * @author Mrhan
 * @date 2021/5/25 11:58
 */
@Configuration
public class SystemConfig implements ApplicationContextAware {


    @ConditionalOnMissingBean({TemplateResolve.class})
    @Bean
    public ThymeleafTemplateResolve thymeleafTemplateResolve() {
        ThymeleafTemplateResolve thymeleafTemplateResolve = new ThymeleafTemplateResolve();
        thymeleafTemplateResolve.addTemplateResolve(new ClassLoaderTemplateResolver());
        return thymeleafTemplateResolve;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHolder.setContext(applicationContext);
    }
}
