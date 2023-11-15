package com.School.controller;


import com.School.dto.request.StudentDepartmentDto;
import com.School.dto.request.StudentDto;
import com.School.dto.response.ApiResponse;
import com.School.dto.response.BaseResponse;
import com.School.enums.Department;

import com.School.schoolModel.School;
import com.School.service.SchoolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/register")
public class StudentController {

    private final SchoolService schoolService;

    @PostMapping("registerStudent")
    public BaseResponse registerStudent (@RequestBody @Valid StudentDto studentDto){
        return schoolService.registerStudent(studentDto);
    }

    @GetMapping("findAllStudent")
    public List<StudentDto> findAllStudent(){
        return schoolService.findAllStudent();
    }

    @GetMapping("findAllStudentInDepartment")
    public List<StudentDepartmentDto>findAllStudentInDepartment(@RequestParam Department department){
        return schoolService.findAllStudentByDepartment(department);
    }

    @GetMapping("findById")
    public BaseResponse findById(@RequestParam Long id) {
        return schoolService.findById(id);
    }

    @GetMapping("sorting/{name}")
    public ApiResponse<List<School>> sorting (@PathVariable String name ) {
        return schoolService.schoolSorting(name);
    }

    @GetMapping("page/{offset}/{pageSize}")
    public ApiResponse<Page<School>> pagination(@PathVariable int offset, @PathVariable int pageSize){
        return schoolService.schoolPagination(offset,pageSize);

    }
    @GetMapping("page/{offset}/{pageSize}/{name}")
    public ApiResponse<Page<School>> paginationAndSorting(@PathVariable int offset, @PathVariable int pageSize,@PathVariable String name) {
        return schoolService.schoolPaginationAndSorting(offset, pageSize, name);
    }

}
