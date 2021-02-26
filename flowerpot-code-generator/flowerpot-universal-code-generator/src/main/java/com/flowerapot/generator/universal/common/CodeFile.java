package com.flowerapot.generator.universal.common;

import java.io.InputStream;
import java.io.PrintWriter;

/**
 * CodeFile
 * 代码文件，生成的文件, 可以说本地文件，也可以是网络文件提供下载
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
    PrintWriter getWriter();

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
        writeSpace(4);
        return this;
    }

    /**
     * 写入空格
     * @param count         空格数量
     * @return CodeFile
     */
    default CodeFile writeSpace(int count) {
        PrintWriter writer = getWriter();
        for (int i = 0; i < count; i++) {
            writer.print(" ");
        }
        return this;
    }

    /**
     * 写入字符串
     * @param str       String
     * @param params    参数
     * @return          CodeFile
     */
    default CodeFile write(String str, Object ...params) {
        getWriter().write(String.format(str, params));
        return this;
    }

    /**
     * 新的一行
     * @param count         换行数量
     * @return CodeFile
     */
    default CodeFile newLine(int count) {
        PrintWriter writer = getWriter();
        for (int i = 0; i < count; i++) {
            writer.print("\n");
        }
        return this;
    }

}
