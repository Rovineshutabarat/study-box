package com.study.box.server.controllers;

import com.study.box.server.models.entity.OneTimePassword;
import com.study.box.server.models.payload.request.EmailRequest;
import com.study.box.server.models.payload.request.LoginRequest;
import com.study.box.server.models.payload.request.OneTimePasswordRequest;
import com.study.box.server.models.payload.request.RegisterRequest;
import com.study.box.server.models.payload.response.LoginResponse;
import com.study.box.server.models.payload.response.RegisterResponse;
import com.study.box.server.models.payload.response.common.SuccessResponse;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;

public interface AuthController {
    ResponseEntity<SuccessResponse<RegisterResponse>> register(RegisterRequest registerRequest);

    ResponseEntity<SuccessResponse<LoginResponse>> login(LoginRequest loginRequest);

    ResponseEntity<SuccessResponse<Void>> sendOneTimePassword(EmailRequest emailRequest) throws MessagingException;

    ResponseEntity<SuccessResponse<OneTimePassword>> verifyOneTimePassword(OneTimePasswordRequest oneTimePasswordRequest);
}
