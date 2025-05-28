package com.study.box.server.models.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "categories")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Category extends BaseEntity {
    @NotBlank(message = "category message cannot be blank.")
    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @Lob
    @NotBlank(message = "category description cannot be blank.")
    private String description;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    @Valid
    private Image image;
}
