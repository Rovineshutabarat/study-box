package com.study.box.server.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Data
@Component
@ConfigurationProperties(prefix = "auth")
public class AuthConfiguration {
    private String jwtSecretKey;
    private Duration jwtAccessTokenExpiration;
    private Duration refreshTokenExpiration;
    private Duration otpExpiration;
}
