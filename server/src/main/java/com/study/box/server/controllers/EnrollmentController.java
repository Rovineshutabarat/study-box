package com.study.box.server.controllers;

import com.study.box.server.models.entity.Enrollment;
import com.study.box.server.models.payload.request.EnrollmentRequest;
import com.study.box.server.models.payload.response.common.SuccessResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EnrollmentController {
    ResponseEntity<SuccessResponse<List<Enrollment>>> findAllByUser(Integer userId);

    ResponseEntity<SuccessResponse<Enrollment>> createEnrollment(EnrollmentRequest enrollmentRequest);

    ResponseEntity<SuccessResponse<Enrollment>> updateEnrollment(Integer id, EnrollmentRequest enrollmentRequest);
}
