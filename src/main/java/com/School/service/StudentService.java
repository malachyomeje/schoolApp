package com.School.service;

import com.School.dto.request.StudentDepartmentDto;
import com.School.dto.request.StudentDto;
import com.School.dto.response.ApiResponse;
import com.School.dto.response.BaseResponse;
import com.School.enums.Department;
import com.School.schoolModel.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    BaseResponse registerStudent (StudentDto studentDto);

    List<StudentDto> findAllStudent();

    List<StudentDepartmentDto> findAllStudentByDepartment(Department department);

    BaseResponse findById(Long id);

    ApiResponse<List<Student>> sorting(String name);

    ApiResponse<Page<Student>> page(int offset, int pageSize);
}
