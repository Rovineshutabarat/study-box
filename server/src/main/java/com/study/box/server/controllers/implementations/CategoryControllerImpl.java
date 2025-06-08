package com.study.box.server.controllers.implementations;

import com.study.box.server.controllers.BaseController;
import com.study.box.server.handler.ResponseHandler;
import com.study.box.server.models.entity.Category;
import com.study.box.server.models.payload.response.common.SuccessResponse;
import com.study.box.server.service.implementations.CategoryServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@AllArgsConstructor
public class CategoryControllerImpl implements BaseController<Category, Integer> {
    private final CategoryServiceImpl categoryService;

    @GetMapping
    @Override
    public ResponseEntity<SuccessResponse<List<Category>>> findAll() {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.OK,
                "Success find all categories.",
                categoryService.findAll()
        );
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<SuccessResponse<Category>> findById(@PathVariable Integer id) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.OK,
                "Success find category by id.",
                categoryService.findById(id)
        );
    }

    @PostMapping
    @Override
    public ResponseEntity<SuccessResponse<Category>> create(@RequestBody @Valid Category category) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.CREATED,
                "Success create new category.",
                categoryService.create(category)
        );
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<SuccessResponse<Category>> update(@PathVariable Integer id, @RequestBody @Valid Category category) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.OK,
                "Success update existing category.",
                categoryService.update(id, category)
        );
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<SuccessResponse<Category>> delete(@PathVariable Integer id) {
        return ResponseHandler.createSuccessResponse(
                HttpStatus.OK,
                "Success deleting category.",
                categoryService.delete(id)
        );
    }
}
