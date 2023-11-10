package com.School.service;

import com.School.dto.request.BookDto;
import com.School.dto.response.BaseResponse;
import com.School.libraryModel.Book;

import java.util.List;

public interface BookService {
    BaseResponse bookRegistration(BookDto bookDto);

    List<Book> findAllBoolInCategory(String categoryName);
}
