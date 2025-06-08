package com.study.box.server.models.exception;

public class AuthException extends RuntimeException {
    public AuthException(String message) {
        super(message);
    }
}
