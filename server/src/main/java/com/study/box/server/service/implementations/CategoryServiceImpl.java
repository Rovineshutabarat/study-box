package com.study.box.server.service.implementations;

import com.study.box.server.models.entity.Category;
import com.study.box.server.models.exception.ResourceNotFoundException;
import com.study.box.server.repositories.CategoryRepository;
import com.study.box.server.service.BaseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements BaseService<Category, Integer> {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format("Category with id %s was not found.", id))
        );
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Integer id, Category category) {
        findById(id);
        category.setId(id);
        return categoryRepository.save(category);
    }

    @Override
    public Category delete(Integer id) {
        Category category = findById(id);
        categoryRepository.delete(category);
        return category;
    }
}
