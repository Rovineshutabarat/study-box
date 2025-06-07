package com.study.box.server.service.implementations;

import com.study.box.server.configurations.AuthConfiguration;
import com.study.box.server.models.entity.RefreshToken;
import com.study.box.server.models.entity.User;
import com.study.box.server.models.exception.AuthException;
import com.study.box.server.models.payload.response.RefreshTokenResponse;
import com.study.box.server.repositories.RefreshTokenRepository;
import com.study.box.server.service.JwtService;
import com.study.box.server.service.RefreshTokenService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class RefreshTokenServiceImpl implements RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final AuthConfiguration authConfiguration;
    private final JwtService jwtService;

    @Override
    public RefreshToken generateRefreshToken(User user) {
        return refreshTokenRepository.findByUser(user)
                .filter(this::isRefreshTokenExpired)
                .orElseGet(() -> refreshTokenRepository.save(RefreshToken.builder()
                        .token(UUID.randomUUID().toString())
                        .user(user)
                        .expiredAt(new Date(System.currentTimeMillis() + authConfiguration.getRefreshTokenExpiration().toMillis()))
                        .build()));
    }

    @Override
    public RefreshTokenResponse refreshToken(String token) {
        RefreshToken refreshToken = refreshTokenRepository.findByToken(token).orElseThrow(
                () -> new AuthException("Refresh token was not found.")
        );

        if (isRefreshTokenExpired(refreshToken)) {
            refreshTokenRepository.delete(refreshToken);
            log.info("Refresh token was already expired.");
            throw new AuthException("Refresh token was already expired.");
        }
        refreshToken.setExpiredAt(new Date(System.currentTimeMillis() + authConfiguration.getRefreshTokenExpiration().toMillis()));
        refreshTokenRepository.save(refreshToken);

        String accessToken = jwtService.generateAccessToken(refreshToken.getUser());

        return RefreshTokenResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken.getToken())
                .build();
    }

    @Override
    public Boolean isRefreshTokenExpired(RefreshToken refreshToken) {
        return refreshToken.getExpiredAt().before(new Date());
    }
}
