package com.flowerpot.common.utils.config.model;

import com.flowerpot.common.utils.config.ConfigTemplate;
import com.flowerpot.common.utils.config.annotation.Checkbox;
import com.flowerpot.common.utils.config.annotation.CheckboxGroup;
import com.flowerpot.common.utils.config.annotation.Input;
import com.flowerpot.common.utils.config.annotation.Switch;
import com.flowerpot.common.utils.config.annotation.Table;
import lombok.Data;

import java.util.List;

/**
 * AppConfig
 *
 * @author Mrhan
 * @date 2021/5/24 16:21
 */
@Data
public class AppConfig implements ConfigTemplate {

    @Input(label = "App名称", placeholder = "请输入App名称", required = true)
    private String name;

    @Input(label = "App密钥", placeholder = "请输入App密钥", type = "password", required = true)
    private String key;

    @CheckboxGroup(label = "启用项", options = {
            @Checkbox(label = "存储服务", value = "1"),
            @Checkbox(label = "邮件服务", value = "2"),
            @Checkbox(label = "日志", value = "3"),
    })
    private List<String> enableList;

    /**
     * JDBC 列表
     */
    @Table(label = "JDBC")
    private List<JDBCConfig> jdbcList;
    /**
     * JDBC 默认配置
     */
    public JDBCConfig defaultJdbc;

    @Data
    public static class JDBCConfig implements ConfigTemplate{

        @Input(label = "连接名称")
        private String name;

        @Input(label = "用户名")
        private String username;

        @Input(label = "密码")
        private String password;

        @Switch(label = "是否启用")
        private Boolean enable;

    }
}
