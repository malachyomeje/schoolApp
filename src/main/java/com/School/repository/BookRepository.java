package com.School.repository;

import com.School.libraryModel.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {


    Optional<Book>findByBookName(String bookName);
    List<Book> findAllByCategoryName(String categoryName );


}
