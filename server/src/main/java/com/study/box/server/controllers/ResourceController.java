package com.study.box.server.controllers;

import com.study.box.server.models.entity.Resource;
import com.study.box.server.models.payload.request.ResourceRequest;
import com.study.box.server.models.payload.response.common.SuccessResponse;
import org.springframework.http.ResponseEntity;

public interface ResourceController {
    ResponseEntity<SuccessResponse<Resource>> createResource(ResourceRequest resourceRequest);

    ResponseEntity<SuccessResponse<Resource>> updateResource(Integer id, ResourceRequest resourceRequest);
}
