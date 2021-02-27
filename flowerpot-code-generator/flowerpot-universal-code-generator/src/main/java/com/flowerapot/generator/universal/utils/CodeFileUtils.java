package com.flowerapot.generator.universal.utils;

import com.flowerapot.generator.universal.common.CodeFile;
import com.flowerapot.generator.universal.common.CodeFileInfo;
import com.flowerpot.common.utils.IoUtils;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * CodeFileUtils
 *  CodeFile
 * @author Mrhan
 * @date 2021/2/27 11:47
 */
@UtilityClass
public class CodeFileUtils {

    /**
     * 写入到文件
     * @param file      File
     * @param directoryPath 文件在的目录路径
     */
    @SneakyThrows
    public void writeToFile(CodeFile file, String directoryPath) {
        CodeFileInfo info = file.getInfo();
        String path = directoryPath + "/" + info.getFileName();
        File writeFile = new File(path);
        if (!writeFile.exists()) {
            boolean newFile = writeFile.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(writeFile);
        IoUtils.writeTo(file.getInputStream(), fileOutputStream);
        fileOutputStream.close();
    }
}
