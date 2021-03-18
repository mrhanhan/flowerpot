package com.flowerapot.generator.universal.utils;

import com.baomidou.mybatisplus.generator.AutoGenerator;

/**
 * CodeGenerator
 * 代码生成器
 *
 * @author Mrhan
 * @date 2021/2/28 12:35
 */
public class CodeGenerator {

    /**
     * 代码生成
     *
     * @param options 生成配置
     */
    public void generate(GeneratorOptions options) {
        AutoGenerator generator = new AutoGenerator();
        generator.setCfg(options.getInjectionConfig())
                .setGlobalConfig(options.getGlobalConfig())
                .setTemplate(options.getTemplateConfig())
                .setStrategy(options.getStrategyConfig())
                .setPackageInfo(options.getPackageConfig())
                .setDataSource(options.getDataSourceConfig())
                .execute();
    }
}
