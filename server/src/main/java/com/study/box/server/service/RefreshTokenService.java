package com.study.box.server.service;

import com.study.box.server.models.entity.RefreshToken;
import com.study.box.server.models.entity.User;
import com.study.box.server.models.payload.response.RefreshTokenResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface RefreshTokenService {
    RefreshToken generateRefreshToken(User user);

    RefreshTokenResponse refreshToken(HttpServletRequest request, HttpServletResponse response);

    Boolean isRefreshTokenExpired(RefreshToken refreshToken);
}
