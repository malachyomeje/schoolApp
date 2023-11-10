package com.School.service;

import com.School.dto.request.CategoryDto;
import com.School.dto.response.BaseResponse;

public interface CategoryService {
    BaseResponse registerCategory (CategoryDto categoryDto);
}
