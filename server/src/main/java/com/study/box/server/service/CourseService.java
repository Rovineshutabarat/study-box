package com.study.box.server.service;

import com.study.box.server.models.entity.Course;
import com.study.box.server.models.payload.request.CourseRequest;

import java.util.List;

public interface CourseService {
    List<Course> findAll();

    Course create(CourseRequest courseRequest);

    Course update(Integer id, CourseRequest courseRequest);

    Boolean canModifyCourse(Integer courseId);
}
