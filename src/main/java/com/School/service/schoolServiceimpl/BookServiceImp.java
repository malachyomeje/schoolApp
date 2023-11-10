package com.School.service.schoolServiceimpl;

import com.School.dto.request.BookDto;
import com.School.dto.response.BaseResponse;
import com.School.libraryModel.Book;
import com.School.libraryModel.Category;
import com.School.repository.BookRepository;
import com.School.repository.CategoryRepository;
import com.School.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImp implements BookService {

    private final CategoryRepository categoryRepository;
    private final BookRepository bookRepository;



@Override
    public BaseResponse bookRegistration(BookDto bookDto){

    Optional<Category> category = categoryRepository.findByCategoryName(bookDto.getCategoryName());

    if (category.isEmpty()) {
        return  new BaseResponse<>("Category can not be found", bookDto.getCategoryName());
    }

        Optional<Book> book = bookRepository.findByBookName(bookDto.getBookName());

        if (book.isPresent()) {
            return  new BaseResponse<>("BOOK ALREADY EXIST", bookDto.getBookName());
        }

        Book book1 = Book.builder()
                .bookName(bookDto.getBookName())
                .author(bookDto.getAuthor())
                .numberOfBooks(bookDto.getNumberOfBooks())
                .isbnNo(bookDto.getIsbnNo())
                .categoryName(bookDto.getCategoryName())
                .build();

        bookRepository.save(book1);
        return new BaseResponse<>("BOOK REGISTRATION SUCCESSFUL", book1);
    }

    @Override
    public List<Book> findAllBoolInCategory(String categoryName){
        return bookRepository.findAllByCategoryName(categoryName);
    }

}
