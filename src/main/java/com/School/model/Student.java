package com.School.model;

import com.School.enums.Department;
import com.School.enums.Faculty;
import com.School.enums.Sex;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "School")
@Table(name = "student_details")
public class Student {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)

    private Long Id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private Faculty faculty;
    @Enumerated(value = EnumType.STRING)
    private Department department;
    private String state;
    private String address;
    private String phoneNumber;
    private String email;
    private String registrationNo;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private String age;
    private String nameOfParent;
    private String parentPhoneNo;
    private String parentAddress;
    @CreationTimestamp
    private Date date;








}
