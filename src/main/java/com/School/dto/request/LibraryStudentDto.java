package com.School.dto.request;

import com.School.enums.Department;
import com.School.enums.Faculty;
import com.School.enums.Sex;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LibraryStudentDto {
    private String name;
    private String phoneNumber;
    private String email;
    private String registrationNo;
    @Enumerated(value = EnumType.STRING)
    private Faculty faculty;
    @Enumerated(value = EnumType.STRING)
    private Department department;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private  String age;
//    @OneToMany
//    private List<Book> book;
}
