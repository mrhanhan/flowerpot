package com.flowerpot.common;

/**
 * ResultEnum
 *
 * @author Mrhan
 * @date 2021/2/24 10:36
 */
public interface ResultEnum {
    /**
     * 响应消息信息
     * @return 响应消息
     */
    String getMessage();

    /**
     * 响应Code
     * @return 响应Code
     */
    int getCode();
}
