package com.study.box.server.handler;

import com.study.box.server.models.enums.ResponseStatus;
import com.study.box.server.models.payload.response.common.ErrorResponse;
import com.study.box.server.models.payload.response.common.SuccessResponse;
import com.study.box.server.models.payload.response.common.ValidationErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

public class ResponseHandler {
    public static <T> ResponseEntity<SuccessResponse<T>> createSuccessResponse(
            HttpStatus httpStatus,
            String message,
            T body) {
        return new ResponseEntity<>(
                SuccessResponse.<T>builder()
                        .status(ResponseStatus.SUCCESS)
                        .code(httpStatus.value())
                        .message(message)
                        .data(body)
                        .build(),
                httpStatus);
    }

    public static ResponseEntity<ErrorResponse> createErrorResponse(
            HttpServletRequest request,
            HttpStatus httpStatus,
            String message) {
        return new ResponseEntity<>(
                ErrorResponse.builder()
                        .status(ResponseStatus.ERROR)
                        .code(httpStatus.value())
                        .message(message)
                        .path(request.getRequestURI())
                        .timestamp(new Date())
                        .build(),
                httpStatus);
    }

    public static ResponseEntity<ValidationErrorResponse> createValidationErrorResponse(
            HttpServletRequest request,
            MethodArgumentNotValidException exception) {
        return new ResponseEntity<>(
                ValidationErrorResponse.builder()
                        .status(ResponseStatus.VALIDATION_ERROR)
                        .code(HttpStatus.BAD_REQUEST.value())
                        .message("Request body contains invalid or missing fields.")
                        .path(request.getRequestURI())
                        .timestamp(new Date())
                        .errors(extractErrors(exception))
                        .build(),
                HttpStatus.BAD_REQUEST);
    }

    private static Map<String, String> extractErrors(MethodArgumentNotValidException exception) {
        return exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .filter(error -> error.getDefaultMessage() != null)
                .collect(Collectors.toMap(
                        FieldError::getField,
                        FieldError::getDefaultMessage,
                        (ppk1, ppk2) -> ppk1)
                );
    }
}
