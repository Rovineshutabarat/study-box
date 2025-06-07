package com.study.box.server.service.implementations;

import com.study.box.server.configurations.AuthConfiguration;
import com.study.box.server.models.entity.RefreshToken;
import com.study.box.server.models.entity.User;
import com.study.box.server.models.exception.AuthException;
import com.study.box.server.models.payload.response.RefreshTokenResponse;
import com.study.box.server.repositories.RefreshTokenRepository;
import com.study.box.server.service.CookieService;
import com.study.box.server.service.JwtService;
import com.study.box.server.service.RefreshTokenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class RefreshTokenServiceImpl implements RefreshTokenService {
    private final RefreshTokenRepository refreshTokenRepository;
    private final AuthConfiguration authConfiguration;
    private final JwtService jwtService;
    private final CookieService cookieService;

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
    public RefreshTokenResponse refreshToken(HttpServletRequest request, HttpServletResponse response) {
        Optional<String> refreshTokenCookie = cookieService.getCookieValue(request, "__refresh_token");
        if (refreshTokenCookie.isEmpty()) {
            log.warn("Refresh token cookie was not found.");
            throw new AuthException("Refresh token cookie was not found.");
        }

        RefreshToken refreshToken = refreshTokenRepository.findByToken(refreshTokenCookie.get()).orElseThrow(
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

        cookieService.setCookieValue(response, "__refresh_token", refreshToken.getToken(), authConfiguration.getRefreshTokenExpiration());
        cookieService.setCookieValue(response, "__refresh_token_expiration", String.valueOf(refreshToken.getExpiredAt().getTime()), authConfiguration.getRefreshTokenExpiration());

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
