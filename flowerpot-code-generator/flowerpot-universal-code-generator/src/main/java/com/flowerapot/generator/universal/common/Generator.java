package com.flowerapot.generator.universal.common;

/**
 * Generator
 * 生成代码的接口
 * @author Mrhan
 * @date 2021/2/26 23:56
 */
public interface Generator {

    /**
     * 生成文件
     * @param file  CodeInfo
     */
    void generator(CodeFile file);
}
