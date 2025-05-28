package com.study.box.server.repositories;

import com.study.box.server.models.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Boolean existsByName(String name);
}
