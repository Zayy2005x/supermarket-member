package com.zayy.supermarketmember.common.properties;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "supermarket.member.jwt")
public class JwtProperties {
    //管理员jwt令牌相关配置
    private String adminSecretKey;
    private long adminTtl;
    private String adminTokenName;
}
