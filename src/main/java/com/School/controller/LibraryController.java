package com.School.controller;

import com.School.dto.request.LibraryDto;
import com.School.dto.response.BaseResponse;
import com.School.service.LibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("library")
public class LibraryController {

    private final LibraryService libraryService;
@PostMapping("libraryRegistration")
    public BaseResponse libraryRegistration(@RequestBody LibraryDto libraryDto){
        return libraryService.libraryRegistration(libraryDto);


    }
}
