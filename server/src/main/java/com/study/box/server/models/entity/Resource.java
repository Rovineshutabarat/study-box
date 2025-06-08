package com.study.box.server.models.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
@Table(name = "resources")
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Resource extends BaseEntity {
    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false)
    private Boolean isPreview = false;

    @Column(nullable = false)
    private Integer orderNumber;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String format;

    @Column(nullable = false)
    private String url;

    @Lob
    private String transcript;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Module module;
}
