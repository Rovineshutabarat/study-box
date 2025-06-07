package com.study.box.server.service;

import com.study.box.server.models.entity.Module;
import com.study.box.server.models.payload.request.ModuleRequest;

import java.util.List;

public interface ModuleService {
    List<Module> findAllByCourseId(Integer courseId);

    Module createModule(ModuleRequest moduleRequest);

    Module updateModule(Integer id, ModuleRequest moduleRequest);
}
