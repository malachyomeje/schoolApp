package com.School.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookDto {

    private String bookName;
    private String author;
    private String numberOfBooks;
    private String isbnNo;
    private String categoryName;
}

