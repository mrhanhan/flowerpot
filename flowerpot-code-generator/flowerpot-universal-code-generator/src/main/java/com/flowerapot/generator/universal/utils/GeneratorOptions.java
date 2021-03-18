package com.flowerapot.generator.universal.utils;

import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * GeneratorOptions
 * 生成器配置
 * @author Mrhan
 * @date 2021/2/28 12:36
 */
@Data
@Builder
@Accessors
public class GeneratorOptions {

    /**
     * 代码保存的位置
     */
    private String src;

    /**
     * 作者
     */
    private String author;

    /**
     * 代码生成器包名
     */
    private String packageName;

    /**
     * DataSource
     */
    private DataSourceConfig dataSourceConfig;

    /**
     * 模板配置
     */
    private TemplateConfig templateConfig;

    /**
     * 包配置
     */
    private PackageConfig packageConfig;

    /**
     * 注入配置
     */
    private InjectionConfig injectionConfig;

    /**
     * 生成策略配置
     */
    private StrategyConfig strategyConfig;

    /**
     * 全局配置
     */
    private GlobalConfig globalConfig;


    public static GeneratorOptions create() {
        return GeneratorOptions.builder()
                       .build();
    }

}
