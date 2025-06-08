package com.study.box.server.service.implementations;

import com.study.box.server.models.entity.Course;
import com.study.box.server.models.entity.Enrollment;
import com.study.box.server.models.entity.User;
import com.study.box.server.models.exception.ResourceNotFoundException;
import com.study.box.server.models.payload.request.EnrollmentRequest;
import com.study.box.server.repositories.EnrollmentRepository;
import com.study.box.server.repositories.UserRepository;
import com.study.box.server.service.BaseService;
import com.study.box.server.service.EnrollmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EnrollmentServiceImpl implements EnrollmentService, BaseService<Enrollment, Integer> {
    private final EnrollmentRepository enrollmentRepository;
    private final UserRepository userRepository;
    private final CourseServiceImpl courseService;

    @Override
    public List<Enrollment> findAllByUser(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with id " + userId + " was not found")
        );
        return enrollmentRepository.findAllByUser(user);
    }

    @Override
    public Enrollment findById(Integer id) {
        return enrollmentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Enrollment with id " + id + " was not found")
        );
    }

    @Override
    public Enrollment createEnrollment(EnrollmentRequest enrollmentRequest) {
        User user = userRepository.findById(enrollmentRequest.getUserId()).orElseThrow(
                () -> new ResourceNotFoundException("User with id " + enrollmentRequest.getUserId() + " was not found")
        );
        Course course = courseService.findById(enrollmentRequest.getCourseId());
        return enrollmentRepository.save(Enrollment.builder()
                .user(user)
                .course(course)
                .status(enrollmentRequest.getStatus())
                .build());
    }

    @Override
    public Enrollment updateEnrollment(Integer id, EnrollmentRequest enrollmentRequest) {
        findById(id);
        User user = userRepository.findById(enrollmentRequest.getUserId()).orElseThrow(
                () -> new ResourceNotFoundException("User with id " + enrollmentRequest.getUserId() + " was not found")
        );
        Course course = courseService.findById(enrollmentRequest.getCourseId());
        return enrollmentRepository.save(Enrollment.builder()
                .id(id)
                .user(user)
                .course(course)
                .status(enrollmentRequest.getStatus())
                .build());
    }

    @Override
    public Enrollment delete(Integer id) {
        Enrollment enrollment = findById(id);
        enrollmentRepository.delete(enrollment);
        return enrollment;
    }
}
