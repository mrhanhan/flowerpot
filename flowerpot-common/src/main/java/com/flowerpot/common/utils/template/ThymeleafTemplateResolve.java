package com.flowerpot.common.utils.template;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.TemplateSpec;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.AbstractConfigurableTemplateResolver;
import org.thymeleaf.templateresolver.AbstractTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import java.util.Map;

/**
 * ThymeleafTemplateResolve
 * 模板解析
 * @author Mrhan
 * @date 2021/5/25 11:45
 */
public class ThymeleafTemplateResolve implements TemplateResolve{

    private final TemplateEngine engine;

    private static final String SUFFIX_TXT = ".txt";
    private static final String SUFFIX_CSS = ".css";
    private static final String SUFFIX_JS = ".js";
    private static final String SUFFIX_JSON = ".json";
    private static final String SUFFIX_HTML = ".html";
    private static final String SUFFIX_XML = ".xml";


    public ThymeleafTemplateResolve() {
        engine = new TemplateEngine();
    }

    @Override
    public String resolve(String templateName, Map<String, Object> parameter) {
        TemplateSpec templateSpec = new TemplateSpec(templateName, getTemplateModel(templateName));
        Context context = new Context();
        context.setVariables(parameter);
        return engine.process(templateSpec, context);
    }

    /**
     * 添加模板解析器
     * @param resolver   模板解析器
     */
    public void addTemplateResolve(ITemplateResolver resolver) {
        if (resolver instanceof AbstractTemplateResolver) {
            AbstractConfigurableTemplateResolver r = (AbstractConfigurableTemplateResolver) resolver;
            r.setForceSuffix(false);
        }
        engine.addTemplateResolver(resolver);
    }

    /**
     * 获取模板Mode
     * @param templateName  模板名称
     * @return  返回模板名称
     */
    private TemplateMode getTemplateModel(String templateName) {
        if (templateName.endsWith(SUFFIX_TXT)) {
            return TemplateMode.TEXT;
        }
        if (templateName.endsWith(SUFFIX_JS)) {
            return TemplateMode.JAVASCRIPT;
        }
        if (templateName.endsWith(SUFFIX_CSS)) {
            return TemplateMode.CSS;
        }
        if (templateName.endsWith(SUFFIX_JSON)) {
            return TemplateMode.JAVASCRIPT;
        }
        if (templateName.endsWith(SUFFIX_XML)) {
            return TemplateMode.XML;
        }
        return TemplateMode.HTML;
    }


}
