package com.flowerpot.admin.config;

import com.flowerpot.common.utils.template.TemplateResolve;
import com.flowerpot.common.utils.template.ThymeleafTemplateResolve;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
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
public class SystemConfig {


    @ConditionalOnMissingBean({TemplateResolve.class})
    @Bean
    public ThymeleafTemplateResolve thymeleafTemplateResolve() {
        ThymeleafTemplateResolve thymeleafTemplateResolve = new ThymeleafTemplateResolve();
        thymeleafTemplateResolve.addTemplateResolve(new ClassLoaderTemplateResolver());
        return thymeleafTemplateResolve;
    }
}
