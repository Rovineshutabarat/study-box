package com.study.box.server.service;

import com.study.box.server.models.payload.request.LoginRequest;
import com.study.box.server.models.payload.request.RegisterRequest;
import com.study.box.server.models.payload.response.LoginResponse;
import com.study.box.server.models.payload.response.RegisterResponse;

public interface AuthService {
    RegisterResponse register(RegisterRequest registerRequest);

    LoginResponse login(LoginRequest loginRequest);
}
