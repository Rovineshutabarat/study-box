package com.study.box.server.service.implementations;

import com.study.box.server.configurations.AuthConfiguration;
import com.study.box.server.models.entity.User;
import com.study.box.server.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;

@Service
@AllArgsConstructor
@Slf4j
public class JwtServiceImpl implements JwtService {
    private final AuthConfiguration authConfiguration;
    private final UserDetailsService userDetailsService;

    @Override
    public Key getPrivateKey() {
        byte[] keyBytes = Decoders.BASE64.decode(authConfiguration.getJwtSecretKey());
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getPrivateKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    @Override
    public String generateAccessToken(User user) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        Map<String, Object> claims = new HashMap<>();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .toList();
        claims.put("roles", roles);

        return Jwts.builder()
                .setId(UUID.randomUUID().toString())
                .setClaims(claims)
                .setSubject(user.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + (authConfiguration.getAccessTokenExpiration() * 5))) // 5 Minutes
                .signWith(getPrivateKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public String extractAccessTokenSubject(String token) {
        return extractAllClaims(token).getSubject();
    }

    @Override
    public Boolean isAccessTokenValid(String token) {
        return !isAccessTokenExpired(token);
    }

    @Override
    public Boolean isAccessTokenExpired(String token) {
        return extractAccessTokenExpiration(token).before(new Date());
    }

    @Override
    public Date extractAccessTokenExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }
}
