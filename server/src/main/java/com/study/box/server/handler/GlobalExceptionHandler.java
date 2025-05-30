package com.study.box.server.handler;

import com.study.box.server.models.exception.AuthException;
import com.study.box.server.models.exception.ResourceNotFoundException;
import com.study.box.server.models.payload.response.common.ErrorResponse;
import com.study.box.server.models.payload.response.common.ValidationErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(
            HttpServletRequest request,
            ResourceNotFoundException exception) {
        return ResponseHandler.createErrorResponse(
                request,
                HttpStatus.NOT_FOUND,
                exception.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception,
            HttpServletRequest request) {
        return ResponseHandler.createValidationErrorResponse(request, exception);
    }

    @ExceptionHandler(AuthException.class)
    public ResponseEntity<ErrorResponse> handleTypeMismatch(HttpServletRequest request, AuthException exception) {
        return ResponseHandler.createErrorResponse(
                request,
                HttpStatus.BAD_REQUEST,
                exception.getMessage());
    }

}
