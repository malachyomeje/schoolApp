package com.School.service;

import com.School.dto.request.LibraryStudentDto;
import com.School.dto.response.BaseResponse;

public interface LibraryStudentService {

    BaseResponse registerLibraryStudent(String studentEmail);
}
