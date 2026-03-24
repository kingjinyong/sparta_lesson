package com.example.sparta.lesson.domain.category.controller;

import com.example.sparta.lesson.domain.category.dto.request.CategoryRequest;
import com.example.sparta.lesson.domain.category.service.CategoryService;
import com.example.sparta.lesson.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ApiResponse<Long> create(@Valid @RequestBody CategoryRequest request) {
        Long result = categoryService.create(request);
        return ApiResponse.ok(result);
    }
}
