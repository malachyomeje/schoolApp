package com.School.dto.request;

import com.School.libraryModel.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BorrowedBookDto {
       private String bookName;
    private String author;
      private List<Book> borrowedBooks;
}
