package com.flowerpot.common;

/**
 * VerifyForm
 *
 * @author Mrhan
 * @date 2021/6/27 18:54
 */
public interface VerifyForm<T> {

    int SAVE_FLAG = 1;
    int UPDATE_FLAG = 2;
    int DELETE_FLAG = 3;

    /**
     * 验证表单数据
     * @param formData  表单数据
     * @param flag      验证标志
     */
    void verifyForm(T formData, int flag);

    /**
     * 验证保存的表单数据
     * @param formData 保存的表单数据
     */
    default void verifySaveForm(T formData) {
        verifyForm(formData, SAVE_FLAG);
    }

    /**
     * 验证更新的表单数据
     * @param formData 更新的表单数据
     */
    default void verifyUpdateForm(T formData) {
        verifyForm(formData, UPDATE_FLAG);
    }

    /**
     * 是否是保存状态
     * @param flag  是否是保存状态
     * @return  返回保存状态
     */
    default boolean isSave(int flag) {
        return flag == SAVE_FLAG;
    }
    /**
     * 是否是修改状态
     * @param flag  是否是保存状态
     * @return  返回保存状态
     */
    default boolean isUpdate(int flag) {
        return flag == UPDATE_FLAG;
    }

    /**
     * 状态是否在其中
     * @param flag  状态
     * @param flags flags
     * @return      如果存在返回true
     */
    default boolean isIn(int flag, int ...flags) {
        for (int f : flags) {
            if (flag == f) {
                return true;
            }
        }
        return  false;
    }

}
