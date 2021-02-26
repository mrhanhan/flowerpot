package com.flowerapot.generator.universal.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Console
 *
 * @author Mrhan
 * @date 2021/2/26 10:18
 */
public class Console {

    public static void print(InputStream is) {
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            isr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
