package com.School.controller;

import com.School.dto.request.CategoryDto;
import com.School.dto.response.BaseResponse;
import com.School.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3/category")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("registerCategory")
    public BaseResponse registerCategory ( @RequestBody CategoryDto categoryDto){
        return categoryService.registerCategory(categoryDto);

    }
}
