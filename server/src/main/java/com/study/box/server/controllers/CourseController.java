package com.study.box.server.controllers;

import com.study.box.server.models.entity.Course;
import com.study.box.server.models.payload.request.CourseRequest;
import com.study.box.server.models.payload.response.common.SuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseController {
    ResponseEntity<SuccessResponse<List<Course>>> findAll();

    ResponseEntity<SuccessResponse<Course>> create(CourseRequest courseRequest);

    ResponseEntity<SuccessResponse<Course>> update(Integer id, CourseRequest courseRequest);
}
