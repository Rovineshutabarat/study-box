package com.study.box.server.models.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.study.box.server.models.anotations.EnumValue;
import com.study.box.server.models.enums.ImageFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.URL;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "images")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Image extends BaseEntity {
    @NotBlank(message = "image name cannot be blank.")
    @Size(min = 5, message = "image name must be at least 5 character.")
    @Size(max = 50, message = "image name must be at most 50 character.")
    @Column(nullable = false, length = 50)
    private String name;

    @URL
    @NotBlank(message = "image url cannot be blank.")
    @Size(min = 10, message = "image url must be at least 10 character.")
    @Column(nullable = false)
    private String url;

    @EnumValue(enumClass = ImageFormat.class, message = "Format must be one of {jpg, jpeg, png}")
    @NotBlank(message = "image format must not be blank.")
    @Size(min = 3, message = "image format must be at least 3 character.")
    private String format;
}
