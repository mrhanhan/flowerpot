package com.flowerpot.admin.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.flowerpot.common.utils.mybatis.BaseEntityMetadataHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MytbatisConfig
 *
 * @author Mrhan
 * @date 2021/4/2 16:02
 */
@Configuration
public class MybatisConfig {

    @Bean
    public MybatisPlusInterceptor paginationInterceptor() {
        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
        return mybatisPlusInterceptor;
    }

    @Bean
    public BaseEntityMetadataHandler baseEntityMetadataHandler() {
        return new BaseEntityMetadataHandler(()->()->100L);
    }

}
