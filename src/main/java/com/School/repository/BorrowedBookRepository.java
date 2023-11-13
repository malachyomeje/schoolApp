package com.School.repository;

import com.School.libraryModel.Book;
import com.School.libraryModel.BorrowedBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BorrowedBookRepository extends JpaRepository<BorrowedBook, Long> {


  }
