package com.study.box.server.service.implementations;

import com.study.box.server.models.entity.Course;
import com.study.box.server.models.entity.Module;
import com.study.box.server.models.entity.User;
import com.study.box.server.models.exception.ResourceNotFoundException;
import com.study.box.server.models.payload.request.ModuleRequest;
import com.study.box.server.repositories.ModuleRepository;
import com.study.box.server.service.BaseService;
import com.study.box.server.service.ModuleService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModuleServiceImpl implements ModuleService, BaseService<Module, Integer> {
    private final ModuleRepository moduleRepository;
    private final CourseServiceImpl courseService;

    @Override
    public List<Module> findAllByCourseId(Integer courseId) {
        Course course = courseService.findById(courseId);
        return moduleRepository.findAllByCourse(course);
    }

    @Override
    public Module findById(Integer id) {
        return moduleRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Module with id %s was not found.", id))
        );
    }

    @Override
    public Module createModule(ModuleRequest moduleRequest) {
        Course course = courseService.findById(moduleRequest.getCourseId());
        return moduleRepository.save(Module.builder()
                .title(moduleRequest.getTitle())
                .description(moduleRequest.getDescription())
                .orderNumber(moduleRequest.getOrderNumber())
                .course(course)
                .build());
    }

    @Override
    public Module updateModule(Integer id, ModuleRequest moduleRequest) {
        findById(id);
        Course course = courseService.findById(moduleRequest.getCourseId());
        return moduleRepository.save(Module.builder()
                .id(id)
                .title(moduleRequest.getTitle())
                .description(moduleRequest.getDescription())
                .orderNumber(moduleRequest.getOrderNumber())
                .course(course)
                .build());
    }

    @Override
    public Module delete(Integer integer) {
        Module module = findById(integer);
        moduleRepository.delete(module);
        return module;
    }

    @Override
    public Boolean canModifyModule(Integer moduleId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        Module module = findById(moduleId);
        return module.getCourse().getInstructor().getEmail().equals(user.getEmail());
    }
}
