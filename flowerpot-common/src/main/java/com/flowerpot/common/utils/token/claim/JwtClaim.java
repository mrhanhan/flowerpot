package com.flowerpot.common.utils.token.claim;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * JwtClaim
 * Jwt 内容
 * 子类需要实现如下内容：
 *  getValue(); 获取数据
 *  handlerSet();   写入数据
 * @author Mrhan
 * @date 2021/2/25 10:56
 */
public interface JwtClaim<T> {
    /**
     * 获取值
     * @return a
     */
    T getValue();

    /**
     * 处理设置数据
     * @param name      Name
     * @param builder   builder
     */
    void handlerSet(String name, JWTCreator.Builder builder);

    @FunctionalInterface
    interface IntegerClaim extends JwtClaim<Integer> {

        @Override
        default void handlerSet(String name, JWTCreator.Builder builder) {
            builder.withClaim(name, getValue());
        }
    }

    @FunctionalInterface
    interface StringClaim extends JwtClaim<String> {

        @Override
        default void handlerSet(String name, JWTCreator.Builder builder) {
            builder.withClaim(name, getValue());
        }
    }


    @FunctionalInterface
    interface LongClaim extends JwtClaim<Long> {

        @Override
        default void handlerSet(String name, JWTCreator.Builder builder) {
            builder.withClaim(name, getValue());
        }
    }

    @FunctionalInterface
    interface DoubleClaim extends JwtClaim<Double> {

        @Override
        default void handlerSet(String name, JWTCreator.Builder builder) {
            builder.withClaim(name, getValue());
        }
    }


    @FunctionalInterface
    interface DateClaim extends JwtClaim<Date> {

        @Override
        default void handlerSet(String name, JWTCreator.Builder builder) {
            builder.withClaim(name, getValue());
        }
    }

    @FunctionalInterface
    interface ListClaim extends JwtClaim<List<? extends Serializable>> {

        @Override
        default void handlerSet(String name, JWTCreator.Builder builder) {
            builder.withClaim(name, getValue());
        }
    }


    @FunctionalInterface
    interface MapClaim extends JwtClaim<Map<String, ? extends Serializable>> {

        @Override
        default void handlerSet(String name, JWTCreator.Builder builder) {
            builder.withClaim(name, getValue());
        }
    }


    @FunctionalInterface
    interface LongArrayClaim extends JwtClaim<Long[]> {

        @Override
        default void handlerSet(String name, JWTCreator.Builder builder) {
            builder.withArrayClaim(name, getValue());
        }
    }

    @FunctionalInterface
    interface StringArrayClaim extends JwtClaim<String[]> {

        @Override
        default void handlerSet(String name, JWTCreator.Builder builder) {
            builder.withArrayClaim(name, getValue());
        }
    }

    @FunctionalInterface
    interface IntegerArrayClaim extends JwtClaim<Integer[]> {

        @Override
        default void handlerSet(String name, JWTCreator.Builder builder) {
            builder.withArrayClaim(name, getValue());
        }
    }


}
