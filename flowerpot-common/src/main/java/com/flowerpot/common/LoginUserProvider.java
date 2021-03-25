package com.flowerpot.common;

/**
 * LoginUserProvider
 * 登录用户信息提供者，提供用户登录信息，可用全局使用.
 *  可以是在处理用户请求时关联用户操作的信息。也可以是异步操作时候的其他地方获取的信息
 * @author Mrhan
 * @date 2021/3/25 21:28
 */
public interface LoginUserProvider<T extends LoginUser> {

    /**
     * 获取登录用户的登录信息
     * @return  返回登录用户的登录信息
     */
    T getLoginUser();

}
