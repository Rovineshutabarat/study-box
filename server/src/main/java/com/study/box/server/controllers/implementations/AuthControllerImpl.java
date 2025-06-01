package com.study.box.server.controllers.implementations;

import com.study.box.server.controllers.AuthController;
import com.study.box.server.handler.ResponseHandler;
import com.study.box.server.models.entity.OneTimePassword;
import com.study.box.server.models.payload.request.EmailRequest;
import com.study.box.server.models.payload.request.LoginRequest;
import com.study.box.server.models.payload.request.OneTimePasswordRequest;
import com.study.box.server.models.payload.request.RegisterRequest;
import com.study.box.server.models.payload.response.LoginResponse;
import com.study.box.server.models.payload.response.RegisterResponse;
import com.study.box.server.models.payload.response.common.SuccessResponse;
import com.study.box.server.service.AuthService;
import com.study.box.server.service.OneTimePasswordService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthControllerImpl implements AuthController {
    private final AuthService authService;
    private final OneTimePasswordService oneTimePasswordService;

    @PostMapping("/register")
    @Override
    public ResponseEntity<SuccessResponse<RegisterResponse>> register(@RequestBody @Valid RegisterRequest registerRequest) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.CREATED,
                "Success register new user.",
                authService.register(registerRequest)
        );
    }

    @PostMapping("/login")
    @Override
    public ResponseEntity<SuccessResponse<LoginResponse>> login(@RequestBody @Valid LoginRequest loginRequest) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.OK,
                "Success authenticate user",
                authService.login(loginRequest)
        );
    }

    @PostMapping("/send-otp")
    @Override
    public ResponseEntity<SuccessResponse<Void>> sendOneTimePassword(@RequestBody @Valid EmailRequest emailRequest) throws MessagingException {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.OK,
                String.format("Success send one time password to email: %s", emailRequest.getEmail()),
                oneTimePasswordService.sendOneTimePassword(emailRequest)
        );
    }

    @PostMapping("/verify-otp")
    @Override
    public ResponseEntity<SuccessResponse<OneTimePassword>> verifyOneTimePassword(@RequestBody @Valid OneTimePasswordRequest oneTimePasswordRequest) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.OK,
                "Success verify one time password",
                oneTimePasswordService.verifyOneTimePassword(oneTimePasswordRequest)
        );
    }
}
