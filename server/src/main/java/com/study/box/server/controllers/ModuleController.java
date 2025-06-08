package com.study.box.server.controllers;

import com.study.box.server.models.entity.Module;
import com.study.box.server.models.payload.request.ModuleRequest;
import com.study.box.server.models.payload.response.common.SuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ModuleController {
    ResponseEntity<SuccessResponse<List<Module>>> findAllByCourseId(Integer courseId);

    ResponseEntity<SuccessResponse<Module>> createModule(ModuleRequest moduleRequest);

    ResponseEntity<SuccessResponse<Module>> updateModule(Integer id, ModuleRequest moduleRequest);
}
