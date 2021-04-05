package com.flowerpot.common.utils.text;

import com.flowerpot.common.utils.Snowflake;
import lombok.experimental.UtilityClass;

import java.math.BigInteger;

/**
 * PasswordGenerator
 *
 * @author Mrhan
 * @date 2021/4/5 22:28
 */
@UtilityClass
public class PasswordUtils {

    private static final Snowflake SEED = new Snowflake(1023);

    /**
     * 生成密码
     * @return 生成13位的密码
     */
    public String generatorPassword() {
        return new BigInteger(SEED.generate() + "").toString(36);
    }

    /**
     * 生成盐
     * @return 生成盐
     */
    public String generatorSalt() {
        return new BigInteger(SEED.generate() + "").toString(24);
    }

    /**
     * 通过加盐加密密码
     * @param password  密码
     * @param salt      盐
     * @return          返回加密后的密码
     */
    public String encrypt(String password, String salt) {
        return EncryptUtils.md5(String.format("%s@%s_%s",  "PWD", password, salt));
    }

    public static void main(String[] args) {
        System.out.println(generatorPassword());
        System.out.println(generatorSalt());
        System.out.println(encrypt("123456", "pwd"));
    }
}
