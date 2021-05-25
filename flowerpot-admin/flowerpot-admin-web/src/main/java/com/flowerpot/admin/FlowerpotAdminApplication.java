package com.flowerpot.admin;

import com.flowerpot.service.mailbox.autoconfigure.EnableFlowerpotMailbox;
import com.flowerpot.service.storage.autoconfigure.EnableFlowerpotStorage;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * FlowerpotAdminApplication
 *
 * @author Mrhan
 * @date 2021/3/20 10:38
 */
@SpringBootApplication
@EnableWebMvc
@ComponentScan(basePackages = {"com.flowerpot.service", "com.flowerpot.admin"})
@MapperScan(basePackages = "com.flowerpot.service.*.dao")
@EnableFlowerpotMailbox
@EnableFlowerpotStorage
public class FlowerpotAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowerpotAdminApplication.class, args);
    }
}
