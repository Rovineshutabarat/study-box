package com.study.box.server.models.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest {
    @NotBlank(message = "email must not be blank.")
    @Email(message = "email must be a valid email address.")
    @Size(min = 6, message = "email must be at least 6 characters long.")
    @Size(max = 100, message = "email must be at most 100 characters long.")
    private String email;

    @NotBlank(message = "password must not be blank.")
    @Size(min = 8, message = "password must be at least 8 characters long.")
    private String password;
}
