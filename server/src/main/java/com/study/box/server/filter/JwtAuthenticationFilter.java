package com.study.box.server.filter;

import com.study.box.server.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Slf4j
@Configuration
@AllArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            log.warn("User is already authenticated.");
            filterChain.doFilter(request, response);
            return;
        }

        try {
            String accessToken = extractBearerToken(request);

            if (!StringUtils.hasText(accessToken)) {
                log.warn("No access token provided.");
                filterChain.doFilter(request, response);
                return;
            }

            if (!jwtService.isAccessTokenValid(accessToken)) {
                log.warn("Invalid or empty access token.");
                filterChain.doFilter(request, response);
                return;
            }

            String email = jwtService.extractAccessTokenSubject(accessToken);
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            log.info("User authenticated successfully : {}.", email);
        } catch (Exception exception) {
            log.error("Failed to authenticate request, {}", exception.getMessage());
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, exception.getMessage());
            return;
        }
        filterChain.doFilter(request, response);
    }

    private String extractBearerToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        if (StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Bearer ")) {
            return authorizationHeader.substring(7);
        }
        return null;
    }

    @Override
    protected boolean shouldNotFilter(@NonNull HttpServletRequest request) throws ServletException {
        String path = request.getRequestURI();
        List<String> publicPath = List.of(
                "/api/auth/login",
                "/api/auth/register",
                "/api/auth/send-otp",
                "/api/auth/verify-otp"
        );
        
        return publicPath.stream().anyMatch(path::startsWith);
    }
}

