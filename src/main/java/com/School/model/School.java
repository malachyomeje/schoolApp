package com.School.model;

import com.School.enums.Department;
import com.School.enums.Faculty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "School")
@Table(name = "school")
public class School {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)

    private Long Id;
    private String name;
    private Faculty faculty;
    private Department department;
    private String state;
    private String address;
    private String phoneNumber;
    private String email;
    private String registrationNo;
    private String sex;
    private String age;
    private String nameOfParent;
    private String parentPhoneNo;
    private String parentAddress;
    @CreationTimestamp
    private Date date;








}
