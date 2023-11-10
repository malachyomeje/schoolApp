package com.School.libraryModel;

import com.School.schoolModel.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Book {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String bookName;
    private String author;
    private String numberOfBooks;
    private String isbnNo;
    private String categoryName;

}