package com.School.controller;

import com.School.dto.request.BookDto;
import com.School.dto.response.BaseResponse;
import com.School.libraryModel.Book;
import com.School.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("book")
public class BookController {

    private final BookService bookService;
@PostMapping("bookRegistration")
    public BaseResponse bookRegistration(@RequestBody BookDto bookDto){
        return bookService.bookRegistration(bookDto);

    }
@GetMapping("findAllBoolInCategory/{categoryName}")
    List<Book> findAllBoolInCategory(@PathVariable String categoryName){
    return bookService.findAllBoolInCategory(categoryName);

    }
}
