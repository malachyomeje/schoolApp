package com.School.controller;


import com.School.dto.request.StudentDepartmentDto;
import com.School.dto.request.StudentDto;
import com.School.dto.response.ApiResponse;
import com.School.dto.response.BaseResponse;
import com.School.enums.Department;

import com.School.schoolModel.Student;
import com.School.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("register")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("registerStudent")
    public BaseResponse registerStudent (@RequestBody @Valid StudentDto studentDto){
        return studentService.registerStudent(studentDto);
    }

    @GetMapping("findAllStudent")
    public List<StudentDto> findAllStudent(){
        return studentService.findAllStudent();
    }

    @GetMapping("findAllStudentInDepartment")
    public List<StudentDepartmentDto>findAllStudentInDepartment(@RequestParam Department department){
        return studentService.findAllStudentByDepartment(department);
    }

    @GetMapping("findById")
    public BaseResponse findById(@RequestParam Long id) {
        return studentService.findById(id);
    }

    @GetMapping("sorting/{name}")
    public ApiResponse<List<Student>> sorting ( @PathVariable String name ) {
        return studentService.sorting(name);
    }

    @GetMapping("page/{offset}/{pageSize}")
    public ApiResponse<Page<Student>> page(@PathVariable int offset, @PathVariable int pageSize){
        return studentService.page(offset,pageSize);

    }
}
