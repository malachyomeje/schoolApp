package com.School.controller;


import com.School.dto.request.StudentDto;
import com.School.dto.response.BaseResponse;
import com.School.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("register")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("registerStudent")
    public BaseResponse registerStudent (@RequestBody @Valid StudentDto studentDto){
        return studentService.registerStudent(studentDto);
    }
}
