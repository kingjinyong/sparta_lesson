package com.example.sparta.lesson.domain.category.service;

import com.example.sparta.lesson.domain.category.CategoryRepository;
import com.example.sparta.lesson.domain.category.dto.request.CategoryRequest;
import com.example.sparta.lesson.domain.category.entity.Category;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    @Transactional
    public Long create(@Valid CategoryRequest request) {

        Category category = Category.builder()
                .name(request.getName())
                .description(request.getDescription())
                .parent(request.getParentId() != null
                        ? categoryRepository.findById(request.getParentId()).orElseThrow(
                                () -> new IllegalArgumentException("Parent category not found"))
                        : null)
                .build();

        categoryRepository.save(category);

        return category.getId();
    }
}
