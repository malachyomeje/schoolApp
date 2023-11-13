package com.School.controller;

import com.School.dto.request.BorrowedBookDto;
import com.School.dto.response.BaseResponse;
import com.School.service.LibraryStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v2/libraryStudent")
public class LibraryStudentController {
    private final LibraryStudentService libraryStudentService;

    @PostMapping("registerLibraryStudent/{studentEmail}")
    public BaseResponse registerLibraryStudent(@PathVariable String studentEmail) {

        return libraryStudentService.registerLibraryStudent(studentEmail);
    }

    @PostMapping("borrowBook")
    public BaseResponse borrowBook(@RequestBody BorrowedBookDto borrowedBookDto) {

        return libraryStudentService.borrowBook(borrowedBookDto);
    }
}