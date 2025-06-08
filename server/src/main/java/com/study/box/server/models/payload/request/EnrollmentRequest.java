package com.study.box.server.models.payload.request;

import com.study.box.server.models.anotations.EnumValue;
import com.study.box.server.models.enums.EnrollmentStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EnrollmentRequest {
    @NotNull(message = "enrollment userId must not be null.")
    private Integer userId;

    @NotNull(message = "enrollment courseId must not be null.")
    private Integer courseId;

    @EnumValue(enumClass = EnrollmentStatus.class, message = "Enrollment status must be one of {ENROLLED, COMPLETED, CANCELLED}")
    @NotBlank(message = "Enrollment status must not be blank.")
    @Size(min = 8, message = "Enrollment status must be at least 8 character.")
    private String status;
}
