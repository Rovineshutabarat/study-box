package com.study.box.server.models.payload.request;

import com.study.box.server.models.anotations.EnumValue;
import com.study.box.server.models.entity.Image;
import com.study.box.server.models.enums.Difficulty;
import com.study.box.server.models.enums.Visibility;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest {
    @NotBlank(message = "course title must not be blank.")
    @Size(min = 5, max = 50, message = "course title must be at least 5 and at most 50 characters long.")
    private String title;

    @NotBlank(message = "course description must not be blank.")
    @Size(min = 10, message = "course description must be at least 10 characters long.")
    private String description;

    @NotNull(message = "course category id must not be null.")
    private Integer categoryId;

    @NotNull(message = "course price must not be null.")
    @PositiveOrZero(message = "course price must be greater than or equal to zero.")
    private Double price;

    @Valid
    private Image image;

    @EnumValue(enumClass = Difficulty.class, message = "Difficulty must be one of {BEGINNER, INTERMEDIATE, ADVANCED}")
    @NotBlank(message = "course difficulty must not be blank.")
    @Size(min = 8, message = "course difficulty must be at least 8 character.")
    private String difficulty;

    @EnumValue(enumClass = Visibility.class, message = "Visibility must be one of {DRAFT, PUBLIC, PRIVATE}")
    @NotBlank(message = "course visibility must not be blank.")
    @Size(min = 5, message = "course visibility must be at least 5 character.")
    private String visibility;
}
