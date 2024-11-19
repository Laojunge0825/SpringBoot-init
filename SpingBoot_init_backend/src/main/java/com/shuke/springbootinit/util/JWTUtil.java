package com.shuke.springbootinit.util;

import com.shuke.springbootinit.common.ErrorCode;
import com.shuke.springbootinit.exception.BaseException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName: JWTUtil
 * @Description:  jwt 工具类
 * @author: 舒克、舒克
 * @Date: 2024/11/18 15:44
 */
@Component
public class JWTUtil {


    /**
     * 使用Keys类生成安全的密钥
     */
    private static final SecretKey SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    /**
     * 指定签名的时候使用的签名算法，也就是header那部分
     */
    private static final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    /**
     * @Author 舒克、舒克
     * @Description 生成token
     * @Date 15:48 2024/11/18
     * @Param
     * @return
     **/
    public static String creatToken(String secretKey, long ttlMillis, Map<String, Object> claims){


        // 生成JWT的时间
        long expMillis = System.currentTimeMillis() + ttlMillis;
        Date exp = new Date(expMillis);
        String token = Jwts.builder()
                .setClaims(claims)
                .setExpiration(exp)
                .signWith(SECRET_KEY)
                .compact();

        return token;

    }

    /**
     * @Author 舒克、舒克
     * @Description token 解密
     * @Date 15:49 2024/11/18
     * @Param
     * @return
     **/
    public static Jws<Claims> parseJWT(String secretKey, String token) {

        Jws<Claims> claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token);

        return claims;
    }



    /**
     * @Author 舒克、舒克
     * @Description  校验token是否有效
     * @Date 9:03 2024/11/19
     * @Param
     * @return
     **/
    public static boolean validateToken(String token){
        if(token == null || "".equals(token)){
            throw new BaseException(ErrorCode.JWT_ERROR);
        }
        try {
            Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            throw new BaseException(403,"无效的token");
        }

    }
}
