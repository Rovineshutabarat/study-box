package com.study.box.server.controllers.implementations;

import com.study.box.server.controllers.BaseController;
import com.study.box.server.controllers.EnrollmentController;
import com.study.box.server.handler.ResponseHandler;
import com.study.box.server.models.entity.Enrollment;
import com.study.box.server.models.payload.request.EnrollmentRequest;
import com.study.box.server.models.payload.response.common.SuccessResponse;
import com.study.box.server.service.implementations.EnrollmentServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enrollment")
@AllArgsConstructor
public class EnrollmentControllerImpl implements EnrollmentController, BaseController<Enrollment, Integer> {
    private final EnrollmentServiceImpl enrollmentService;

    @Override
    @GetMapping("/user/{userId}")
    public ResponseEntity<SuccessResponse<List<Enrollment>>> findAllByUser(@PathVariable Integer userId) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.OK,
                "Success find all enrollments by user id.",
                enrollmentService.findAllByUser(userId)
        );
    }

    @Override
    @PostMapping
    public ResponseEntity<SuccessResponse<Enrollment>> createEnrollment(@RequestBody @Valid EnrollmentRequest enrollmentRequest) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.CREATED,
                "Success create new enrollment.",
                enrollmentService.createEnrollment(enrollmentRequest)
        );
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponse<Enrollment>> updateEnrollment(@PathVariable Integer id, @RequestBody @Valid EnrollmentRequest enrollmentRequest) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.OK,
                "Success update existing enrollment.",
                enrollmentService.updateEnrollment(id, enrollmentRequest)
        );
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponse<Enrollment>> delete(@PathVariable Integer id) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.OK,
                "Success deleting enrollment.",
                enrollmentService.delete(id)
        );
    }
}
