package com.example.sparta.lesson.domain.category.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CategoryRequest {

    @NotBlank
    private String name;

    private String description;

    private Long parentId;
}
