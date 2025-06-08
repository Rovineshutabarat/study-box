package com.study.box.server.service;

import com.study.box.server.models.entity.Enrollment;
import com.study.box.server.models.payload.request.EnrollmentRequest;

import java.util.List;

public interface EnrollmentService {
    List<Enrollment> findAllByUser(Integer userId);

    Enrollment createEnrollment(EnrollmentRequest enrollmentRequest);

    Enrollment updateEnrollment(Integer id, EnrollmentRequest enrollmentRequest);
}
