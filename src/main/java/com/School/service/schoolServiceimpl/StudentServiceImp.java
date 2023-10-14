package com.School.service.schoolServiceimpl;

import com.School.dto.request.StudentDto;
import com.School.dto.response.BaseResponse;
import com.School.enums.Department;
import com.School.enums.Faculty;
import com.School.enums.Sex;
import com.School.model.Student;
import com.School.repository.StudentRepository;
import com.School.service.StudentService;
import com.School.utils.SchoolUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService {

    private  final StudentRepository studentRepository;


    @Override
    public BaseResponse registerStudent(StudentDto studentDto){
       Optional<Student> student = studentRepository.findAllByEmail(studentDto.getEmail());

       if (student.isPresent()){
           return new BaseResponse<>("Student Already Exist",studentDto.getEmail());

       }
       Department department =SchoolUtils.department(studentDto.getDepartment());
       if (department==null){
         return new BaseResponse<>("INVALID DEPARTMENT",studentDto.getDepartment());
       }

        Faculty faculty =SchoolUtils.faculty(studentDto.getFaculty());
        if (faculty==null){
            return new BaseResponse<>("INVALID FACULTY",studentDto.getFaculty());
        }

        Sex sex =SchoolUtils.sex(studentDto.getSex());
        if (sex==null){
            return new BaseResponse<>("INVALID SEX",studentDto.getSex());
        }

        if (studentDto.getPhoneNumber().trim().length() == 0 || !SchoolUtils.validPhoneNumber(studentDto.getPhoneNumber())) {
            return new BaseResponse<>("Wrong PhoneNumber, Enter Correct PhoneNumber",studentDto.getPhoneNumber());
        }


       Student student1 =Student.builder()
               .name(studentDto.getName())
               .faculty(faculty)
               .department(department)
               .email(studentDto.getEmail())
               .age(studentDto.getAge())
               .address(studentDto.getAddress())
               .phoneNumber(studentDto.getPhoneNumber())
               .registrationNo(studentDto.getRegistrationNo())
               .sex(sex)
               .state(studentDto.getState())
               .nameOfParent(studentDto.getNameOfParent())
               .parentPhoneNo(studentDto.getParentPhoneNo())
               .parentAddress(studentDto.getParentAddress())
               .build();
       studentRepository.save(student1);
        return new BaseResponse<>("registration successful",student1);
    }

}
