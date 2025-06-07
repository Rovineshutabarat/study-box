package com.study.box.server.repositories;

import com.study.box.server.models.entity.Course;
import com.study.box.server.models.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer> {
    List<Module> findAllByCourse(Course course);
}
