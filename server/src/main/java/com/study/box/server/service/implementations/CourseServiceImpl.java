package com.study.box.server.service.implementations;

import com.study.box.server.models.entity.Category;
import com.study.box.server.models.entity.Course;
import com.study.box.server.models.entity.User;
import com.study.box.server.models.exception.ResourceNotFoundException;
import com.study.box.server.models.payload.request.CourseRequest;
import com.study.box.server.repositories.CourseRepository;
import com.study.box.server.repositories.UserRepository;
import com.study.box.server.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final CategoryServiceImpl categoryService;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(Integer id) {
        return courseRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Course with id %s was not found.", id))
        );
    }

    @Override
    public Course create(CourseRequest courseRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        User instructor = userRepository.findByEmail(user.getEmail()).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Instructor with username %s was not found.", authentication.getName()))
        );

        Category category = categoryService.findById(courseRequest.getCategoryId());

        return courseRepository.save(Course.builder()
                .title(courseRequest.getTitle())
                .description(courseRequest.getDescription())
                .instructor(instructor)
                .category(category)
                .price(courseRequest.getPrice())
                .image(courseRequest.getImage())
                .difficulty(courseRequest.getDifficulty())
                .visibility(courseRequest.getVisibility())
                .build());
    }

    @Override
    public Course update(Integer id, CourseRequest courseRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();

        User instructor = userRepository.findByEmail(user.getEmail()).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Instructor with username %s was not found.", authentication.getName()))
        );

        Category category = categoryService.findById(courseRequest.getCategoryId());

        return courseRepository.save(Course.builder()
                .id(id)
                .title(courseRequest.getTitle())
                .description(courseRequest.getDescription())
                .instructor(instructor)
                .category(category)
                .price(courseRequest.getPrice())
                .image(courseRequest.getImage())
                .difficulty(courseRequest.getDifficulty())
                .visibility(courseRequest.getVisibility())
                .build());
    }

    @Override
    public Course delete(Integer id) {
        Course course = findById(id);
        courseRepository.delete(course);
        return course;
    }

    @Override
    public Boolean canModifyCourse(Integer courseId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        Course course = findById(courseId);
        return course.getInstructor().getEmail().equals(user.getEmail());
    }
}
