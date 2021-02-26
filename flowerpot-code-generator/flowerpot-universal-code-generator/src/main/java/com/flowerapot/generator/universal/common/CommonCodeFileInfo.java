package com.flowerapot.generator.universal.common;

/**
 * AbstractCodeInfo
 * 通用代码信息
 * @author Mrhan
 * @date 2021/2/26 9:45
 */
public class CommonCodeFileInfo implements CodeFileInfo {

    /**
     * 代码文件名称
     */
    private String fileName;

    /**
     * 文件类型
     */
    private String contentType;

    public CommonCodeFileInfo(String fileName) {
        this(fileName, CONTENT_TYPE_TEXT_PLAIN);
    }

    public CommonCodeFileInfo(String name, String contentType) {
        this.fileName = name;
        this.contentType = contentType;
    }


    @Override
    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
