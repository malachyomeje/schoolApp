package com.School.dto.request;

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
public class StudentDto implements Serializable {

    @NotBlank(message = "name must not be empty")
    private String name;
    @NotBlank(message = "faculty must not be empty")
    private String faculty;
    @NotBlank(message = "department must not be empty")
    private String department;
    @NotBlank(message = "state must not be empty")
    private String state;
    @NotBlank(message = "address must not be empty")
    private String address;
    @NotBlank(message = "enter correct phoneNumber")
    private String phoneNumber;
    @Email(regexp = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$"
            ,message = "enter correct email")
    private String email;
    @NotBlank(message = "registrationNo must not be empty")
    private String registrationNo;
    @NotBlank(message = "sex must not be empty")
    private String sex;
    @NotBlank(message = "age must not be empty")
    private String age;
    @NotBlank(message = "nameOfParent must not be empty")
    private String nameOfParent;
    @NotBlank(message = "parentPhoneNo must not be empty")
    private String parentPhoneNo;
    @NotBlank(message = "parentAddress must not be empty")
    private String parentAddress;
}