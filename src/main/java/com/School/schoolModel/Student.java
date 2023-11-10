package com.School.schoolModel;

import com.School.enums.Department;
import com.School.enums.Faculty;
import com.School.enums.Sex;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Entity

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
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
    @JsonIgnore
    private String nameOfParent;
    @JsonIgnore
    private String parentPhoneNo;
    @JsonIgnore
    private String parentAddress;
    @CreationTimestamp
    private Date date;



}
