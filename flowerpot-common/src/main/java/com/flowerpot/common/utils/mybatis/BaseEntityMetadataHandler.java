package com.flowerpot.common.utils.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.flowerpot.common.LoginUserProvider;
import com.flowerpot.common.enums.EffectiveEnum;
import com.flowerpot.common.model.BaseEntity;
import com.flowerpot.common.utils.UniqueCodeGen;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;
import java.util.Objects;

/**
 * BaseEntityMetadataHandler
 *
 * @author Mrhan
 * @date 2021/3/25 21:25
 */
public class BaseEntityMetadataHandler implements MetaObjectHandler {

    private final LoginUserProvider<?> loginUserProvider;

    public BaseEntityMetadataHandler(LoginUserProvider<?> loginUserProvider) {
        this.loginUserProvider = loginUserProvider;
    }

    @Override
    public void insertFill(MetaObject metaObject) {
        // 填充用户数据
        Object originalObject = metaObject.getOriginalObject();
        if (originalObject instanceof BaseEntity) {
            fillInsertData((BaseEntity)originalObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        // 填充修改时候的数据
        Object originalObject = metaObject.getOriginalObject();
        if (originalObject instanceof BaseEntity) {
            fillUpdateData((BaseEntity)originalObject);
        }
    }


    private void fillInsertData(BaseEntity originalObject) {
        // 设置ID
        if (Objects.isNull(originalObject.getId())) {
            originalObject.setId(UniqueCodeGen.genId());
        }
        // 设置创建者和时间
        if (Objects.isNull(originalObject.getCreateBy())) {
            originalObject.setCreateBy(loginUserProvider.getLoginUser().getId());
        }
        // 设置创建者和时间
        if (Objects.isNull(originalObject.getCreateTime())) {
            originalObject.setCreateTime(new Date());
        }
        // 设置是否数据有效
        if (Objects.isNull(originalObject.getEffective())) {
            originalObject.setEffective(EffectiveEnum.EFFECTIVE.getKey());
        }
    }


    private void fillUpdateData(BaseEntity originalObject) {

        // 设置创建者和时间
        if (Objects.isNull(originalObject.getModifyBy())) {
            originalObject.setModifyBy(loginUserProvider.getLoginUser().getId());
        }
        // 设置创建者和时间
        if (Objects.isNull(originalObject.getModifyTime())) {
            originalObject.setModifyTime(new Date());
        }
    }
}
