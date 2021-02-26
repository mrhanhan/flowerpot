package com.flowerapot.generator.universal.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
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
     * 字符流
     */
    private final PrintWriter writer;

    /**
     * 代码文件信息
     */
    private final CodeFileInfo info;

    public AbstractCodeFile(CodeFileInfo info) {
        this.info = info;
        this.outputStream = new ByteArrayOutputStream();
        this.writer = new PrintWriter(this.outputStream);
    }

    @Override
    public CodeFileInfo getInfo() {
        return info;
    }

    @Override
    public PrintWriter getWriter() {
        return writer;
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
