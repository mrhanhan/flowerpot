package com.flowerpot.common.utils;


import com.flowerpot.common.utils.token.JwtTokenSubject;
import com.flowerpot.common.utils.token.JwtTokenUtils;

public class JwtTokenUtilsTest {

    public static void main(String[] args) {
        JwtTokenSubject jwtTokenSubject = JwtTokenSubject.create("Hello World", 10000);
        jwtTokenSubject.setClaim("Hello", 1);
        String token = JwtTokenUtils.sign(jwtTokenSubject);
        System.out.println(token);

        JwtTokenSubject verify = JwtTokenUtils.verify(token);

        System.out.println(verify.getClaim("Hello").asInt());
    }
}