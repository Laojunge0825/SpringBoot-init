package com.shuke.springbootinit.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName: JWTProperty
 * @Description:  JWT  配置文件
 * @author: 舒克、舒克
 * @Date: 2024/11/18 15:56
 */

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtProperty {

    private String secretKey;

    private long expiration;

    private String tokenName;


    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public long getExpiration() {
        return expiration;
    }

    public void setExpiration(long expiration) {
        this.expiration = expiration;
    }

    public String getTokenName() {
        return tokenName;
    }

    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }


}
