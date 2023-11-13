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
public class BorrowedBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String libraryStudent;
    private String bookName;
    private String isbnNo;
    private String author;

}
