package com.flowerpot.common.utils.token;

import com.auth0.jwt.interfaces.Claim;
import com.flowerpot.common.enums.AlgorithmProviderEnum;
import com.flowerpot.common.utils.token.claim.JwtClaim;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * JwtToken
 *
 * @author Mrhan
 * @date 2021/2/25 10:11
 */
@Builder
@Accessors
@AllArgsConstructor
@NoArgsConstructor
@Getter(value = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
public class JwtTokenSubject {

    /**
     * JWT ID用于标识该JWT
     */
    private String id;
    /**
     * 加密主体
     */
    private String subject;
    /**
     * 发行方
     */
    private String issuer;
    /**
     * 用户
     */
    private String[] audiences;

    /**
     * 设置发行时间
     */
    private Date issuedAt;
    /**
     * 到期时间
     */
    private Date expiresAt;
    /**
     * 算法供应者
     */
    private AlgorithmProvider algorithmProvider;
    /**
     *
     */
    private Map<String, Object> headerMap;

    /**
     * ClaimMap
     */
    private Map<String, JwtClaim<?>> claimMap;
    /**
     * Claim Data Map
     */
    private Map<String, Object> claimDataMap;
    /**
     * Put Header
     * @param name      Name
     * @param value     Value
     * @return
     */
     public JwtTokenSubject putHeader(String name, Object value) {
        if (headerMap == null) {headerMap = new HashMap<>(4);}
        headerMap.put(name, value);
        return this;
    }

    /**
     * 获取Name
     * @param name      Name
     * @return          Claim
     */
    public Claim getHeaderClaim(String name) {
         return null;
    }

    /**
     * 获取Claim
     * @param name      Name
     * @return          Claim
     */
    public Claim getClaim(String name) {
         return null;
    }

    /**
     * Token 是否超时
     * @return  返回是否超时
     */
    public boolean isExpires() {
        // 如果发布时间小于超时时间，代表不会超时
        return (issuedAt.getTime() < expiresAt.getTime()) && System.currentTimeMillis() > expiresAt.getTime();
    }

    // -----------------------------------------------------------------------------------------------------------------
    // static methods
    // -----------------------------------------------------------------------------------------------------------------
    /**
     * 构建 JwtTokenSubject
     * @return  JwtTokenSubject
     */
     public static JwtTokenSubject create(String id, String subject, String issuer, long expiresTime, AlgorithmProvider algorithmProvider, String ...audiences) {
        Date now = new Date();
        return JwtTokenSubject.builder().id(id)
                .subject(subject)
                .issuer(issuer)
                .issuedAt(now)
                .expiresAt(new Date(now.getTime() + expiresTime))
                .algorithmProvider(algorithmProvider)
                .audiences(audiences).build();
    }

    public static JwtTokenSubject create(String subject, long expiresTime, String ...audiences) {
        return create(UUID.randomUUID().toString(), subject, "server", expiresTime, AlgorithmProviderEnum.COMMON, audiences);
    }

    // -----------------------------------------------------------------------------------------------------------------
    // 设置Claim数据
    // -----------------------------------------------------------------------------------------------------------------

    /**
     * 设置Claim数据
     * @param name      Name
     * @param value     Value
     * @return          返回值
     */
    public JwtTokenSubject setClaim(String name, Integer value) {
        return setClaim(name, ()->value);
    }

    /**
     * 设置Claim数据
     * @param name      Name
     * @param value     Value
     * @return          返回值
     */
    public JwtTokenSubject setClaim(String name, int value) {
        return setClaim(name, Integer.valueOf(value));
    }


    /**
     * 设置Claim数据
     * @param name      Name
     * @param value     Value
     * @return          返回值
     */
    public  JwtTokenSubject setClaim(String name, String value) {
        return setClaim(name, ()->value);
    }

    /**
     * 设置Claim数据
     * @param name      Name
     * @param value     Value
     * @return          返回值
     */
    public JwtTokenSubject setClaim(String name, Long value) {
        return setClaim(name, ()->value);
    }
    /**
     * 设置Claim数据
     * @param name      Name
     * @param value     Value
     * @return          返回值
     */
    public JwtTokenSubject setClaim(String name, long value) {
        return setClaim(name, Long.valueOf(value));
    }

    /**
     * 设置Claim数据
     * @param name      Name
     * @param value     Value
     * @return          返回值
     */
    public JwtTokenSubject setClaim(String name, double value) {
        return setClaim(name, Double.valueOf(value));
    }

    /**
     * 设置Claim数据
     * @param name      Name
     * @param value     Value
     * @return          返回值
     */
    public JwtTokenSubject setClaim(String name, Double value) {
        return setClaim(name, ()->value);
    }

    /**
     * 设置Claim数据
     * @param name      Name
     * @param value     Value
     * @return          返回值
     */
    public JwtTokenSubject setClaim(String name, Date value) {
        return setClaim(name, ()->value);
    }
    /**
     * 设置Claim数据
     * @param name      Name
     * @param value     Value
     * @return          返回值
     */
    public JwtTokenSubject setClaim(String name, List<? extends Serializable> value) {
        return setClaim(name, ()->value);
    }
    /**
     * 设置Claim数据
     * @param name      Name
     * @param value     Value
     * @return          返回值
     */
    public JwtTokenSubject setClaim(String name, Map<String, ? extends Serializable> value) {
        return setClaim(name, ()->value);
    }
    /**
     * 设置Claim数据
     * @param name      Name
     * @param value     Value
     * @return          返回值
     */
    public JwtTokenSubject setClaim(String name, Integer[] value) {
        return setClaim(name, ()->value);
    }

    /**
     * 设置Claim数据
     * @param name      Name
     * @param value     Value
     * @return          返回值
     */
    public JwtTokenSubject setClaim(String name, String[] value) {
        return setClaim(name, ()->value);
    }

    /**
     * 设置Claim数据
     * @param name      Name
     * @param claim     JwtClaim
     * @return          返回值
     */
    public JwtTokenSubject setClaim(String name, JwtClaim.IntegerClaim claim) {
        return setCustomizeClaim(name, claim);
    }

    /**
     * 设置Claim数据
     * @param name      Name
     * @param claim     JwtClaim
     * @return          返回值
     */
    public JwtTokenSubject setClaim(String name, JwtClaim.LongClaim claim) {
        return setCustomizeClaim(name, claim);
    }

    /**
     * 设置Claim数据
     * @param name      Name
     * @param claim     JwtClaim
     * @return          返回值
     */
    public JwtTokenSubject setClaim(String name, JwtClaim.DateClaim claim) {
        return setCustomizeClaim(name, claim);
    }

    /**
     * 设置Claim数据
     * @param name      Name
     * @param claim     JwtClaim
     * @return          返回值
     */
    public JwtTokenSubject setClaim(String name, JwtClaim.DoubleClaim claim) {
        return setCustomizeClaim(name, claim);
    }

    /**
     * 设置Claim数据
     * @param name      Name
     * @param claim     JwtClaim
     * @return          返回值
     */
    public JwtTokenSubject setClaim(String name, JwtClaim.ListClaim claim) {
        return setCustomizeClaim(name, claim);
    }

    /**
     * 设置Claim数据
     * @param name      Name
     * @param claim     JwtClaim
     * @return          返回值
     */
    public JwtTokenSubject setClaim(String name, JwtClaim.MapClaim claim) {
        return setCustomizeClaim(name, claim);
    }

    /**
     * 设置Claim数据
     * @param name      Name
     * @param claim     JwtClaim
     * @return          返回值
     */
    public JwtTokenSubject setClaim(String name, JwtClaim.StringClaim claim) {
        return setCustomizeClaim(name, claim);
    }

    /**
     * 设置Claim数据
     * @param name      Name
     * @param claim     JwtClaim
     * @return          返回值
     */
    public JwtTokenSubject setClaim(String name, JwtClaim.IntegerArrayClaim claim) {
        return setCustomizeClaim(name, claim);
    }

    /**
     * 设置Claim数据
     * @param name      Name
     * @param claim     JwtClaim
     * @return          返回值
     */
    public JwtTokenSubject setClaim(String name, JwtClaim.LongArrayClaim claim) {
        return setCustomizeClaim(name, claim);
    }

    /**
     * 设置Claim数据
     * @param name      Name
     * @param claim     JwtClaim
     * @return          返回值
     */
    public JwtTokenSubject setClaim(String name, JwtClaim.StringArrayClaim claim) {
        return setCustomizeClaim(name, claim);
    }


    /**
     * 设置Claim数据
     * @param name      Name
     * @param claim     JwtClaim
     * @return          JwtTokenSubject
     */
    public JwtTokenSubject setCustomizeClaim(String name, JwtClaim<?> claim) {
        if (claimMap == null) { claimMap = new HashMap<>(2);}
        if (claimDataMap == null) { claimDataMap = new HashMap<>(2);}
        claimMap.put(name, claim);
        claimDataMap.put(name, claim.getValue());
        return this;
    }
}
