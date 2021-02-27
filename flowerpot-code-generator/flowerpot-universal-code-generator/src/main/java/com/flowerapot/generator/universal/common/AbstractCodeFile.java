package com.flowerapot.generator.universal.common;

import lombok.SneakyThrows;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * AbstractCodeFile
 *
 * @author Mrhan
 * @date 2021/2/26 9:48
 */
public class AbstractCodeFile implements CodeFile {

    /**
     * 内容输出的位置
     */
    private final ByteArrayOutputStream outputStream;

    /**
     * 代码文件信息
     */
    private final CodeFileInfo info;

    @SneakyThrows
    public AbstractCodeFile(CodeFileInfo info) {
        this.info = info;
        this.outputStream = new ByteArrayOutputStream();
    }

    @Override
    public CodeFileInfo getInfo() {
        return info;
    }

    @Override
    public ByteArrayOutputStream getOutputStream() {
        return outputStream;
    }

    @Override
    public InputStream getInputStream() {
        return new ByteArrayInputStream(outputStream.toByteArray());
    }

    @Override
    public void close() throws Exception {
        outputStream.close();
    }
}
