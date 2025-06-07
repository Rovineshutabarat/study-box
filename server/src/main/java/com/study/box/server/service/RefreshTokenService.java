package com.study.box.server.service;

import com.study.box.server.models.entity.RefreshToken;
import com.study.box.server.models.entity.User;
import com.study.box.server.models.payload.response.RefreshTokenResponse;

public interface RefreshTokenService {
    RefreshToken generateRefreshToken(User user);

    RefreshTokenResponse refreshToken(String refreshToken);

    Boolean isRefreshTokenExpired(RefreshToken refreshToken);
}
