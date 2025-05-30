package com.study.box.server.service;

import com.study.box.server.models.entity.User;
import io.jsonwebtoken.Claims;

import java.security.Key;
import java.util.Date;

public interface JwtService {
    Key getPrivateKey();

    Claims extractAllClaims(String token);

    String generateAccessToken(User user);

    String extractAccessTokenSubject(String token);

    Boolean isAccessTokenValid(String token);

    Boolean isAccessTokenExpired(String token);

    Date extractAccessTokenExpiration(String token);
}
