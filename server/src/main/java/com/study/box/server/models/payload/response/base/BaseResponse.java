package com.study.box.server.models.payload.response.base;

import com.study.box.server.models.enums.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseResponse {
    private ResponseStatus status;
    private Integer code;
    private String message;
}
