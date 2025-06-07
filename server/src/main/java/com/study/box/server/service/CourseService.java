package com.study.box.server.service;

import com.study.box.server.models.entity.Course;
import com.study.box.server.models.payload.request.CourseRequest;

import java.util.List;

public interface CourseService {
    List<Course> findAll();

    Course findById(Integer id);

    Course create(CourseRequest courseRequest);

    Course update(Integer id, CourseRequest courseRequest);

    Course delete(Integer id);

    Boolean canModifyCourse(Integer courseId);
}
