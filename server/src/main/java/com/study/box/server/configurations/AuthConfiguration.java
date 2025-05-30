package com.study.box.server.configurations;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public class AuthConfiguration {
    private final String jwtSecretKey;
    private final Long accessTokenExpiration;
    private final String bearerTokenPrefix;
    private final Long refreshTokenExpiration;
    private final String refreshTokenCookieName;
    private final String refreshTokenExpirationCookieName;

    public AuthConfiguration(
            @Value("${jwt.secret.key}") String jwtSecretKey,
            @Value("${jwt.access.token.expiration}") Long accessTokenExpiration,
            @Value("${jwt.bearer.token.prefix}") String bearerTokenPrefix,
            @Value("${jwt.refresh.token.expiration}") Long refreshTokenExpiration,
            @Value("${jwt.refresh.token.cookie.name}") String refreshTokenCookieName,
            @Value("${jwt.refresh.token.expiration.cookie.name}") String refreshTokenExpirationCookieName) {
        this.jwtSecretKey = jwtSecretKey;
        this.accessTokenExpiration = accessTokenExpiration;
        this.bearerTokenPrefix = bearerTokenPrefix;
        this.refreshTokenExpiration = refreshTokenExpiration;
        this.refreshTokenCookieName = refreshTokenCookieName;
        this.refreshTokenExpirationCookieName = refreshTokenExpirationCookieName;
    }
}
