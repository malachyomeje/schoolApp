package com.School.model;

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
@Table(name = "library")
public class Library {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String bookName;
    private String author;
    private String numberOfBooks;
    private String  isbnNo;

    @OneToOne
    private Student student;

}
