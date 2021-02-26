package com.flowerapot.generator.universal.common;

import jdk.jfr.ContentType;

/**
 * CodeFileInfo
 * 代码文件后缀名
 * @author Mrhan
 * @date 2021/2/26 9:21
 */
public interface CodeFileInfo {

    String CONTENT_TYPE_TEXT_PLAIN = "text/plain";

    /**
     * 文件名称
     * @return      文件名称
     */
    String getFileName();

    /**
     * 获取代码文件内容类型
     * @return      默认返回是 text/plain
     */
    default String getContentType() {
        return CONTENT_TYPE_TEXT_PLAIN;
    }
}
