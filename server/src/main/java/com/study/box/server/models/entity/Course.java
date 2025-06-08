package com.study.box.server.models.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.study.box.server.models.enums.Difficulty;
import com.study.box.server.models.enums.Visibility;
import jakarta.persistence.*;
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
@Table(name = "courses")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Course extends BaseEntity {
    @Column(nullable = false, length = 50)
    private String title;
    @Lob
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instructor_id", referencedColumnName = "id", nullable = false)
    private User instructor;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private Category category;

    private Double price;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "image_id", referencedColumnName = "id")
    private Image image;

    @Column(nullable = false)
    private String difficulty = Difficulty.BEGINNER.name();

    @Column(nullable = false)
    private String visibility = Visibility.DRAFT.name();
}
