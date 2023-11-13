package com.School.libraryModel;

import com.School.enums.Department;
import com.School.enums.Faculty;
import com.School.enums.Sex;
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
public class LibraryStudent {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String registrationNo;
    @Enumerated(value = EnumType.STRING)
    private Faculty faculty;
    @Enumerated(value = EnumType.STRING)
    private Department department;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    @OneToMany
    private List<BorrowedBook> borrowedBook;
}
