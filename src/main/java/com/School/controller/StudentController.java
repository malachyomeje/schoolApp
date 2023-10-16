package com.School.controller;


import com.School.dto.request.StudentDepartmentDto;
import com.School.dto.request.StudentDto;
import com.School.dto.response.BaseResponse;
import com.School.enums.Department;

import com.School.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("findByEmail")
    public BaseResponse findByEmail(@RequestParam Long id) {
        return studentService.findByEmail(id);
    }

}
