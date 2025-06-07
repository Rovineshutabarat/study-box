package com.study.box.server.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.time.Duration;
import java.util.Optional;

public interface CookieService {
    Optional<String> getCookieValue(HttpServletRequest request, String name);

    void setCookieValue(HttpServletResponse response, String name, String value, Duration maxAge);

    void removeCookie(HttpServletRequest request, String name);
}
