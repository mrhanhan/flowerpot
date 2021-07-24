package com.flowerpot.service.authorize.utils;

import com.flowerpot.common.utils.UniqueCodeGen;
import com.flowerpot.common.utils.convert.TextConvertUtil;
import com.flowerpot.service.authorize.dto.AuthRuleExpression;
import com.flowerpot.service.authorize.dto.param.AuthResourceParam;
import com.flowerpot.service.authorize.dto.param.AuthResourceRuleParam;
import com.flowerpot.service.authorize.entity.AuthResource;
import com.flowerpot.service.authorize.entity.AuthResourceRule;
import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * AuthResourceConverts
 *
 * @author Mrhan
 * @date 2021/7/17 19:12
 */
@UtilityClass
public class AuthResourceConverts {

    /**
     * 将AuthResourceRuleParam 转换为  AuthResourceRule
     *
     * @param authResourceRuleParam 授权资源规则参数
     * @param authResourceId        授权资源ID
     * @return 返回转换后的授权资源规则列表
     */
    public List<AuthResourceRule> convertAuthResourceRuleList(AuthResourceRuleParam authResourceRuleParam, Long authResourceId) {
        List<AuthResourceRule> authResourceRuleList = new ArrayList<>();
        convertAuthResourceRule(authResourceRuleList, authResourceRuleParam, null, authResourceId);
        return authResourceRuleList;
    }

    /**
     * 授权资源信息，转换为参数信息
     *
     * @param authResource         授权资源数据库对象
     * @param authResourceRuleList 授权资源规则数据库对象
     * @return 转换为保存时请求的参数
     */
    public AuthResourceParam convertAuthResourceParam(AuthResource authResource, List<AuthResourceRule> authResourceRuleList) {
        AuthResourceParam authResourceParam = new AuthResourceParam();
        authResourceParam.setAuthResource(authResource);
        // 解析规则
        if (!CollectionUtils.isEmpty(authResourceRuleList)) {
            authResourceParam.setAuthResourceRule(convertAuthResourceRuleParam(authResourceRuleList));
        }
        return authResourceParam;
    }

    /**
     * 数据库存储的对象转换为保存时传递的参数结构
     *
     * @param authResourceRuleList 数据库规则列表
     * @return 返回保存时的参数对象
     */
    private AuthResourceRuleParam convertAuthResourceRuleParam(List<AuthResourceRule> authResourceRuleList) {
        Map<Integer, AuthResourceRuleParam> authResourceRuleParamMap = new HashMap<>(authResourceRuleList.size());
        authResourceRuleList.forEach(t -> {
            AuthResourceRuleParam param = new AuthResourceRuleParam();
            param.setId(t.getId());
            param.setType(t.getType());
            AuthRuleExpression expression = TextConvertUtil.toObject(t.getExpression(), AuthRuleExpression.class);
            param.setExpression(expression);
            param.setDesc(t.getDesc());
            authResourceRuleParamMap.put(expression.getId(), param);
        });
        // 设置关联关系
        AuthResourceRuleParam[] rootAuthResourceRuleParam = new AuthResourceRuleParam[1];
        authResourceRuleParamMap.forEach((k, v) -> {
            if (k == 0) {
                rootAuthResourceRuleParam[0] = v;
            } else {
                AuthRuleExpression expression = v.getExpression();
                AuthResourceRuleParam parentParam = authResourceRuleParamMap.get(expression.getGroupLevel());
                if (Objects.nonNull(parentParam)) {
                    if (Objects.isNull(parentParam.getChildren())) {
                        parentParam.setChildren(new ArrayList<>());
                    }
                    parentParam.getChildren().add(v);
                }
            }
        });
        return rootAuthResourceRuleParam[0];
    }

    /**
     * 转换单个AuthResourceRuleParam 和 内部规则 为 AuthResourceRule
     *
     * @param authResourceRuleList        转换后得规则对象列表
     * @param authResourceRuleParam       授权资源规则参数
     * @param parentAuthResourceRuleParam 所属分组
     * @param authResourceId              授权资源ID
     */
    private void convertAuthResourceRule(List<AuthResourceRule> authResourceRuleList, AuthResourceRuleParam authResourceRuleParam, AuthResourceRuleParam parentAuthResourceRuleParam, Long authResourceId) {
        AuthResourceRule authResourceRule = new AuthResourceRule();
        authResourceRule.setId(UniqueCodeGen.genId());
        authResourceRule.setResourceId(authResourceId);
        authResourceRule.setType(authResourceRuleParam.getType());
        authResourceRule.setDesc(authResourceRuleParam.getDesc());
        AuthRuleExpression expression = authResourceRuleParam.getExpression();
        if (Objects.isNull(parentAuthResourceRuleParam)) {
            expression.setId(1);
            expression.setGroupLevel(0);
            expression.setGroupPath("0");
        } else {
            AuthRuleExpression parentExpression = parentAuthResourceRuleParam.getExpression();
            expression.setGroupLevel(parentExpression.getId());
            expression.setGroupPath(parentExpression.getGroupPath() + "," + expression.getId());
        }
        authResourceRule.setExpression(TextConvertUtil.toJsonText(expression));
        // 设置子规则
        authResourceRuleList.add(authResourceRule);
        List<AuthResourceRuleParam> children = authResourceRuleParam.getChildren();
        if (Objects.nonNull(children)) {
            for (int i = 0; i < children.size(); i++) {
                AuthResourceRuleParam childrenAuthResourceRuleParam = children.get(i);
                childrenAuthResourceRuleParam.getExpression().setId(expression.getId() * 10 + i);
                convertAuthResourceRule(authResourceRuleList, childrenAuthResourceRuleParam, authResourceRuleParam, authResourceId);
            }
        }
    }
}
