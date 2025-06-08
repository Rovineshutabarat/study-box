package com.study.box.server.controllers.implementations;

import com.study.box.server.controllers.BaseController;
import com.study.box.server.controllers.ModuleController;
import com.study.box.server.handler.ResponseHandler;
import com.study.box.server.models.entity.Module;
import com.study.box.server.models.payload.request.ModuleRequest;
import com.study.box.server.models.payload.response.common.SuccessResponse;
import com.study.box.server.service.implementations.ModuleServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/module")
@AllArgsConstructor
public class ModuleControllerImpl implements ModuleController, BaseController<Module, Integer> {
    private final ModuleServiceImpl moduleService;

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<Module>> findById(@PathVariable Integer id) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.OK,
                "Success find module by id.",
                moduleService.findById(id)
        );
    }

    @Override
    @GetMapping("/course/{id}")
    public ResponseEntity<SuccessResponse<List<Module>>> findAllByCourseId(@PathVariable Integer id) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.OK,
                "Success find all module by course id.",
                moduleService.findAllByCourseId(id)
        );
    }

    @Override
    @PostMapping
    public ResponseEntity<SuccessResponse<Module>> createModule(@RequestBody @Valid ModuleRequest moduleRequest) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.CREATED,
                "Success create new module.",
                moduleService.createModule(moduleRequest)
        );
    }

    @Override
    @PutMapping("/{id}")
    @PreAuthorize("@moduleServiceImpl.canModifyModule(#id)")
    public ResponseEntity<SuccessResponse<Module>> updateModule(@PathVariable Integer id, @RequestBody @Valid ModuleRequest moduleRequest) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.OK,
                "Success update existing module.",
                moduleService.updateModule(id, moduleRequest)
        );
    }

    @Override
    @PutMapping("/{id}")
    @PreAuthorize("@moduleServiceImpl.canModifyModule(#id)")
    public ResponseEntity<SuccessResponse<Module>> delete(@PathVariable Integer id) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.OK,
                "Success deleting resource.",
                moduleService.delete(id)
        );
    }
}
