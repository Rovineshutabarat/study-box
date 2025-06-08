package com.study.box.server.repositories;

import com.study.box.server.models.entity.Enrollment;
import com.study.box.server.models.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {
    List<Enrollment> findAllByUser(User user);
}
