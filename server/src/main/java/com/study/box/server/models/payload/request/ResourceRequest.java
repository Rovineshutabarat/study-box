package com.study.box.server.models.payload.request;

import com.study.box.server.models.anotations.EnumValue;
import com.study.box.server.models.enums.ResourceFormat;
import com.study.box.server.models.enums.ResourceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResourceRequest {
    @NotBlank(message = "resource title must not be blank.")
    @Size(min = 5, max = 50, message = "resource title must be at least 5 and at most 50 characters long.")
    private String title;

    @NotNull(message = "resource isPreview must not be null.")
    private Boolean isPreview;

    @NotNull(message = "resource order number must not be null.")
    private Integer orderNumber;

    @EnumValue(enumClass = ResourceType.class, message = "Resource type must be one of {VIDEO, DOCUMENT}")
    @NotBlank(message = "Resource type must not be blank.")
    @Size(min = 5, message = "Resource type must be at least 5 character.")
    private String type;

    @EnumValue(enumClass = ResourceFormat.class, message = "Resource format must be one of {mp4, doc, docx, clsx, pdf, txt}")
    @NotBlank(message = "Resource format must not be blank.")
    @Size(min = 3, message = "Resource format must be at least 3 character.")
    private String format;

    @NotBlank(message = "resource url must not be blank.")
    @URL(message = "resource url must be a valid url.")
    private String url;

    private String transcript;

    @NotNull(message = "module id must not be null.")
    private Integer moduleId;
}
