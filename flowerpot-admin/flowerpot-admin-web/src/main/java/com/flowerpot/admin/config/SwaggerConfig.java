package com.flowerpot.admin.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * SwaggerConfig
 *
 * @author Mrhan
 * @date 2021/4/2 15:23
 */
@Configuration
//@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                       .title("Flowerpot Admin接口")
                       .description("Flowerpot Admin接口")
                       .version("1.0.0")
                       .build();
    }

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                       .apiInfo(apiInfo())
                       .select()
                       .apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).build();
    }



}
