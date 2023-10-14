package com.School.service;

import com.School.dto.request.StudentDto;
import com.School.dto.response.BaseResponse;

public interface StudentService {
    BaseResponse registerStudent (StudentDto studentDto);
}
