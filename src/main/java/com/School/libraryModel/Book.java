package com.School.libraryModel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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