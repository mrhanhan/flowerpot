package com.flowerapot.generator.universal.common;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * CodeFile
 * 代码文件，生成的文件, 可以是本地文件，也可以是网络文件提供下载
 * @author Mrhan
 * @date 2021/2/26 0:36
 */
public interface CodeFile extends AutoCloseable{

    /**
     * 代码文件信息
     * @return  CodeFileInfo
     */
    CodeFileInfo getInfo();

    /**
     * 获取CodeInfo字符输入流
     * @return  PrintWriter
     */
    OutputStream getOutputStream();

    /**
     * CodeInfo获取输出流
     * @return  InputStream
     */
    InputStream getInputStream();

    // -----------------------------------------------------------------------------------------------------------------
    // 快捷写入
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * tab 符号
     * @param tabCount      tab数量
     * @return CodeFile
     */
    default CodeFile writeTab(int tabCount) {
        for (int i = 0; i < tabCount; i++) {
            writeSpace(4);
        }
        return this;
    }

    /**
     * 写入空格
     * @param count         空格数量
     * @return CodeFile
     */
    @SneakyThrows
    default CodeFile writeSpace(int count) {
        for (int i = 0; i < count; i++) {
            write(" ");
        }
        return this;
    }

    /**
     * 写入字符串
     * @param str       String
     * @param params    参数
     * @return          CodeFile
     */
    @SneakyThrows
    default CodeFile write(String str, Object ...params) {
        getOutputStream().write(String.format(str, params).getBytes());
        return this;
    }

    /**
     * 新的一行
     * @param count         换行数量
     * @return CodeFile
     */
    @SneakyThrows
    default CodeFile newLine(int count) {
        for (int i = 0; i < count; i++) {
            write("\n");
        }
        return this;
    }


}
