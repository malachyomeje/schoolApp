package com.School.service;

import com.School.dto.request.StudentDepartmentDto;
import com.School.dto.request.StudentDto;
import com.School.dto.response.BaseResponse;
import com.School.enums.Department;

import java.util.List;

public interface StudentService {
    BaseResponse registerStudent (StudentDto studentDto);

    List<StudentDto> findAllStudent();

    List<StudentDepartmentDto> findAllStudentByDepartment(Department department);

    BaseResponse findById(Long id);
}
