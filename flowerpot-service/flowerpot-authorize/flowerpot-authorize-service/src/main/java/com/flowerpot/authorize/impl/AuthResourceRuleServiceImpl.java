package com.flowerpot.authorize.impl;

import com.flowerpot.authorize.service.AuthResourceRuleService;
import com.flowerpot.common.model.BaseServiceImpl;
import com.flowerpot.authorize.entity.AuthResourceRule;
import com.flowerpot.authorize.mapper.AuthResourceRuleMapper;
import org.springframework.stereotype.Service;

/**
 * AuthResourceRuleServiceImpl
 *
 * @author Mrhan
 * @date 2021/6/27 12:39
 */
@Service
public class AuthResourceRuleServiceImpl extends BaseServiceImpl<AuthResourceRule, AuthResourceRuleMapper> implements AuthResourceRuleService {

}
