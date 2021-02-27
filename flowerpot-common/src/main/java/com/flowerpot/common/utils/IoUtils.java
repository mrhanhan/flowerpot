package com.flowerpot.common.utils;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * IoUtils
 *
 * @author Mrhan
 * @date 2021/2/27 12:25
 */
@UtilityClass
public class IoUtils {

    /**
     * 输入流写入输出流
     * @param is        输入流
     * @param os        输出流
     */
    @SneakyThrows
    public void writeTo(InputStream is, OutputStream os) {
        byte[] data = new byte[2048];
        int length = 0;
        while ((length = is.read(data)) > 0) {
            os.write(data, 0, length);
        }
    }
}
