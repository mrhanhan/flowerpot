package com.flowerpot.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * FlowerpotAdminApplication
 *
 * @author Mrhan
 * @date 2021/3/20 10:38
 */
@SpringBootApplication
@EnableWebMvc
public class FlowerpotAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlowerpotAdminApplication.class, args);
    }
}
