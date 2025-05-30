package com.study.box.server.controllers.implementations;

import com.study.box.server.controllers.AuthController;
import com.study.box.server.handler.ResponseHandler;
import com.study.box.server.models.payload.request.LoginRequest;
import com.study.box.server.models.payload.request.RegisterRequest;
import com.study.box.server.models.payload.response.LoginResponse;
import com.study.box.server.models.payload.response.RegisterResponse;
import com.study.box.server.models.payload.response.common.SuccessResponse;
import com.study.box.server.service.AuthService;
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
}
