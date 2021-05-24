package com.flowerpot.common.utils;

import lombok.experimental.UtilityClass;

import java.io.File;

/**
 * PathUtils
 * 路径工具类
 * @author Mrhan
 * @date 2021/2/28 12:39
 */
@UtilityClass
public class PathUtil {
    /**
     * 输出目录
     */
    public static final String SOURCE_OUT_PATH = "\\target\\classes\\";
    public static final String TEST_SOURCE_OUT_PATH = "\\target\\test-classes\\";
    public static final String TEST_SOURCE_PATH = "\\src\\test\\java\\";
    public static final String SOURCE_PATH = "\\src\\main\\java\\";

    /**
     * 获取相对路径
     * @param cls               Class
     * @param relativePath      相对于class的相对路径
     * @return                  返回对应的绝对路径
     */
    public String getAbsolutePath(Class<?> cls, String relativePath) {
        return new File(cls.getResource(relativePath).getFile()).getAbsolutePath();
    }

    /**
     * 相对路径
     * @param cls   cls
     * @return      返回源代码的绝对路径
     */
    public String getCodeSourcePath(Class<?> cls, String relativePath) {
        return getAbsolutePath(cls, relativePath)
                       .replace(SOURCE_OUT_PATH, SOURCE_PATH)
                       .replace(TEST_SOURCE_OUT_PATH, TEST_SOURCE_PATH);
    }


    public static void main(String[] args) {
        // 获取绝对路径
        System.out.println(PathUtil.getAbsolutePath(PathUtil.class, ""));
        // 获取源码路径 E:\cloud\flowerpot\flowerpot-common\src\main\java
        //            E:\cloud\flowerpot\flowerpot-common\scr\main\java
        System.out.println(PathUtil.getCodeSourcePath(PathUtil.class, ""));
    }
}
