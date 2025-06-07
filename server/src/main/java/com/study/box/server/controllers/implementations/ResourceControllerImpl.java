package com.study.box.server.controllers.implementations;

import com.study.box.server.controllers.ResourceController;
import com.study.box.server.handler.ResponseHandler;
import com.study.box.server.models.entity.Resource;
import com.study.box.server.models.payload.request.ResourceRequest;
import com.study.box.server.models.payload.response.common.SuccessResponse;
import com.study.box.server.service.ResourceService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resource")
@AllArgsConstructor
public class ResourceControllerImpl implements ResourceController {
    private final ResourceService resourceService;

    @Override
    @PostMapping
    public ResponseEntity<SuccessResponse<Resource>> createResource(@RequestBody @Valid ResourceRequest resourceRequest) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.CREATED,
                "Success create new resource.",
                resourceService.createResource(resourceRequest)
        );
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse<Resource>> updateResource(@PathVariable Integer id, @RequestBody @Valid ResourceRequest resourceRequest) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.OK,
                "Success update existing resource.",
                resourceService.updateResource(id, resourceRequest)
        );
    }
}
