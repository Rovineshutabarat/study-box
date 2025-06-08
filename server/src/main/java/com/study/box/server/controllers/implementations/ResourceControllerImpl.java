package com.study.box.server.controllers.implementations;

import com.study.box.server.controllers.BaseController;
import com.study.box.server.controllers.ResourceController;
import com.study.box.server.handler.ResponseHandler;
import com.study.box.server.models.entity.Resource;
import com.study.box.server.models.payload.request.ResourceRequest;
import com.study.box.server.models.payload.response.common.SuccessResponse;
import com.study.box.server.service.implementations.ResourceServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resource")
@AllArgsConstructor
public class ResourceControllerImpl implements ResourceController, BaseController<Resource, Integer> {
    private final ResourceServiceImpl resourceService;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<Resource>> findById(@PathVariable Integer id) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.OK,
                "Success find resource by id.",
                resourceService.findById(id)
        );
    }

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
    @PreAuthorize("@resourceServiceImpl.canModifyResource(#id)")
    public ResponseEntity<SuccessResponse<Resource>> updateResource(@PathVariable Integer id, @RequestBody @Valid ResourceRequest resourceRequest) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.OK,
                "Success update existing resource.",
                resourceService.updateResource(id, resourceRequest)
        );
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("@resourceServiceImpl.canModifyResource(#id)")
    public ResponseEntity<SuccessResponse<Resource>> delete(@PathVariable Integer id) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.OK,
                "Success deleting resource.",
                resourceService.delete(id)
        );
    }
}
