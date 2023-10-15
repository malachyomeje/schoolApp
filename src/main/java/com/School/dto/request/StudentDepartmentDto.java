package com.School.dto.request;

import com.School.enums.Department;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StudentDepartmentDto {
    private String name;
    private Department department;
    private String state;
    private String address;
    private String phoneNumber;
    private String email;
    private String registrationNo;
    private String sex;
    private String age;

}