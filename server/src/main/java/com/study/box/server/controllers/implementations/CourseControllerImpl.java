package com.study.box.server.controllers.implementations;

import com.study.box.server.controllers.BaseController;
import com.study.box.server.controllers.CourseController;
import com.study.box.server.handler.ResponseHandler;
import com.study.box.server.models.entity.Course;
import com.study.box.server.models.payload.request.CourseRequest;
import com.study.box.server.models.payload.response.common.SuccessResponse;
import com.study.box.server.service.implementations.CourseServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
@AllArgsConstructor
public class CourseControllerImpl implements CourseController, BaseController<Course, Integer> {
    private final CourseServiceImpl courseService;

    @Override
    @GetMapping
    public ResponseEntity<SuccessResponse<List<Course>>> findAll() {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.OK,
                "Success find all courses.",
                courseService.findAll()
        );
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponse<Course>> findById(@PathVariable Integer id) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.OK,
                "Success find course by id.",
                courseService.findById(id)
        );
    }

    @Override
    @PostMapping
    public ResponseEntity<SuccessResponse<Course>> create(@RequestBody @Valid CourseRequest courseRequest) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.CREATED,
                "Success create new course.",
                courseService.create(courseRequest)
        );
    }

    @Override
    @PutMapping("/{id}")
    @PreAuthorize("@courseServiceImpl.canModifyCourse(#id)")
    public ResponseEntity<SuccessResponse<Course>> update(@PathVariable Integer id, @RequestBody @Valid CourseRequest courseRequest) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.OK,
                "Success update existing course.",
                courseService.update(id, courseRequest)
        );
    }

    @Override
    @DeleteMapping("/{id}")
    @PreAuthorize("@courseServiceImpl.canModifyCourse(#id)")
    public ResponseEntity<SuccessResponse<Course>> delete(@PathVariable Integer id) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.OK,
                "Success deleting course.",
                courseService.delete(id)
        );
    }
}
