package com.flowerpot.common.utils.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Verification;
import com.flowerpot.common.utils.token.AlgorithmProvider;
import com.flowerpot.common.utils.token.AlgorithmProviderManager;
import com.flowerpot.common.utils.token.JwtTokenSubject;
import com.flowerpot.common.utils.token.claim.JwtClaim;
import lombok.experimental.UtilityClass;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * JwtTokenUtils
 *
 * @author Mrhan
 * @date 2021/2/24 10:57
 */
@UtilityClass
public class JwtTokenUtils {

    private static final String ALGORITHM_NAME = "algorithm";
    /**
     * 加密Token
     * @param tokenSubject         加密主体
     * @return      Token Str
     */
    public String sign(JwtTokenSubject tokenSubject) {
        JWTCreator.Builder jwtBuilder = JWT.create();
        // 设置发行方
        jwtBuilder.withIssuer(tokenSubject.getIssuer());
        // 设置主体
        jwtBuilder.withSubject(tokenSubject.getSubject());
        // 设置用户
        jwtBuilder.withAudience(tokenSubject.getAudiences());
        // 设置发行时间
        jwtBuilder.withIssuedAt(tokenSubject.getIssuedAt());
        // 设置到期时间
        jwtBuilder.withExpiresAt(tokenSubject.getExpiresAt());
        // 设置加密类型
        AlgorithmProvider algorithmProvider = tokenSubject.getAlgorithmProvider();
        // 设置jwt头
        Map<String, Object> headerMap = tokenSubject.getHeaderMap();
        if (!CollectionUtils.isEmpty(headerMap)) {
            headerMap = new HashMap<>(tokenSubject.getHeaderMap());
            headerMap.put(ALGORITHM_NAME, algorithmProvider.name());
            jwtBuilder.withHeader(headerMap);
        } else {
            headerMap = new HashMap<>();
            headerMap.put(ALGORITHM_NAME, algorithmProvider.name());
            jwtBuilder.withHeader(headerMap);
        }
        // 设置 Claim
        Map<String, JwtClaim<?>> claimMap = tokenSubject.getClaimMap();
        if (!CollectionUtils.isEmpty(claimMap)) {
            claimMap.forEach((k, v) -> v.handlerSet(k, jwtBuilder));
        }
        return jwtBuilder.sign(algorithmProvider.getAlgorithm());
    }

    /**
     * 验证JwtToken
     * @param jwtToken       JWT
     * @return          验证
     */
    public JwtTokenSubject verify(String jwtToken) {
        DecodedJWT decode = null;
        try {
            DecodedJWT commonJwt = JWT.decode(jwtToken);
            // 获取加密算法的名称
            String algorithmName = commonJwt.getHeaderClaim(ALGORITHM_NAME).asString();
            AlgorithmProvider byName = AlgorithmProviderManager.findByName(algorithmName);
            if (Objects.isNull(byName)) {
                throw new NullPointerException(algorithmName + " is null");
            }
            JWTVerifier jwtVerifier = JWT.require(byName.getAlgorithm()).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(jwtToken);
            JwtTokenSubject jwtTokenSubject = new JwtTokenSubject(){
                @Override
                public Claim getHeaderClaim(String name) {
                    return commonJwt.getHeaderClaim(name);
                }

                @Override
                public Claim getClaim(String name) {
                    return decodedJWT.getClaim(name);
                }
            };

            jwtTokenSubject.setId(commonJwt.getId());
            List<String> audience = commonJwt.getAudience();
            if (!CollectionUtils.isEmpty(audience)) {
                jwtTokenSubject.setAudiences(audience.toArray(new String[audience.size()]));
            }
            jwtTokenSubject.setAlgorithmProvider(byName);
            jwtTokenSubject.setIssuedAt(commonJwt.getIssuedAt());
            jwtTokenSubject.setExpiresAt(commonJwt.getExpiresAt());
            jwtTokenSubject.setIssuer(commonJwt.getIssuer());
            jwtTokenSubject.setSubject(commonJwt.getSubject());
            return jwtTokenSubject;
        }catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}
