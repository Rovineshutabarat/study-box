package com.study.box.server.models.payload.request;

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
public class ModuleRequest {
    @NotBlank(message = "module title must not be blank.")
    @Size(min = 5, max = 50, message = "module title must be at least 5 and at most 50 characters long.")
    private String title;

    @NotBlank(message = "module description must not be blank.")
    @Size(min = 10, message = "module description must be at least 10 characters long.")
    private String description;

    @NotNull(message = "module order number must not be null.")
    private Integer orderNumber;

    @NotNull(message = "course id must not be null.")
    private Integer courseId;
}
