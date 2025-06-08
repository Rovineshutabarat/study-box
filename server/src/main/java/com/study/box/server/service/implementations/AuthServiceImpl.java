package com.study.box.server.service.implementations;

import com.study.box.server.models.entity.Role;
import com.study.box.server.models.entity.User;
import com.study.box.server.models.exception.AuthException;
import com.study.box.server.models.exception.ResourceNotFoundException;
import com.study.box.server.models.payload.request.LoginRequest;
import com.study.box.server.models.payload.request.RegisterRequest;
import com.study.box.server.models.payload.response.LoginResponse;
import com.study.box.server.models.payload.response.RegisterResponse;
import com.study.box.server.repositories.RoleRepository;
import com.study.box.server.repositories.UserRepository;
import com.study.box.server.service.AuthService;
import com.study.box.server.service.JwtService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public RegisterResponse register(RegisterRequest registerRequest) {
        List<Role> roles = new ArrayList<>();
        roles.add(roleRepository.findByName("USER").orElseThrow(
                () -> new ResourceNotFoundException("User role was not found.")
        ));

        User user = userRepository.save(User.builder()
                .username(registerRequest.getUsername())
                .email(registerRequest.getEmail())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .roles(roles)
                .isVerified(false)
                .build());

        return RegisterResponse.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .roles(user.getRoles().stream().map(Role::getName).toList())
                .isVerified(user.getIsVerified())
                .build();
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(
                () -> new AuthException("User was not found.")
        );

        // Disable for development purpose
        // if (!user.getIsVerified()) {
        // throw new AuthException("User is not verified.");
        // }

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(),
                loginRequest.getPassword()
        ));

        String accessToken = jwtService.generateAccessToken(user);

        return LoginResponse.builder()
                .user(user)
                .accessToken(accessToken)
                .build();
    }

}
