package com.School.service;

import com.School.dto.request.LibraryDto;
import com.School.dto.response.BaseResponse;

public interface LibraryService {
    BaseResponse libraryRegistration(LibraryDto libraryDto);
}
