package com.flowerpot.admin.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
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
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    @Bean
    public BaseEntityMetadataHandler baseEntityMetadataHandler() {
        return new BaseEntityMetadataHandler(()->()->100L);
    }

}
