package com.School.service.schoolServiceimpl;

import com.School.dto.request.StudentDepartmentDto;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService {

    private final StudentRepository studentRepository;


    @Override
    public BaseResponse registerStudent(StudentDto studentDto) {
        Optional<Student> student = studentRepository.findAllByEmail(studentDto.getEmail());

        if (student.isPresent()) {
            return new BaseResponse<>("Student Already Exist", studentDto.getEmail());

        }
        Department department = SchoolUtils.department(studentDto.getDepartment());
        if (department == null) {
            return new BaseResponse<>("INVALID DEPARTMENT", studentDto.getDepartment());
        }

        Faculty faculty = SchoolUtils.faculty(studentDto.getFaculty());
        if (faculty == null) {
            return new BaseResponse<>("INVALID FACULTY", studentDto.getFaculty());
        }

        Sex sex = SchoolUtils.sex(studentDto.getSex());
        if (sex == null) {
            return new BaseResponse<>("INVALID SEX", studentDto.getSex());
        }

        if (studentDto.getPhoneNumber().trim().length() == 0 || !SchoolUtils.validPhoneNumber(studentDto.getPhoneNumber())) {
            return new BaseResponse<>("Wrong PhoneNumber, Enter Correct PhoneNumber", studentDto.getPhoneNumber());
        }


        Student student1 = Student.builder()
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
        return new BaseResponse<>("registration successful", student1);
    }

    @Override
    public List<StudentDto> findAllStudent() {
        List<Student> list = studentRepository.findAll();
        List<StudentDto> student = new ArrayList<>();

        for (Student student1 : list) {

            StudentDto studentDto1 = new StudentDto();
            studentDto1.setName(student1.getName());
            studentDto1.setFaculty(String.valueOf(student1.getFaculty()));
            studentDto1.setDepartment(student1.getDepartment().name());
            studentDto1.setEmail(student1.getEmail());
            studentDto1.setAge(student1.getAge());
            studentDto1.setAddress(student1.getAddress());
            studentDto1.setPhoneNumber(student1.getPhoneNumber());
            studentDto1.setRegistrationNo(student1.getRegistrationNo());
            studentDto1.setSex(String.valueOf(student1.getSex()));
            studentDto1.setState(student1.getState());
            studentDto1.setNameOfParent(student1.getNameOfParent());
            studentDto1.setParentPhoneNo(student1.getParentPhoneNo());
            studentDto1.setParentAddress(student1.getParentAddress());

            student.add(studentDto1);
        }
        return student;
    }


    @Override
    public List<StudentDepartmentDto> findAllStudentByDepartment(Department department) {
        List<Student> department1 = studentRepository.findAllByDepartment(department);
        List<StudentDepartmentDto> response = new ArrayList<>();

        for (Student student1 : department1) {

            StudentDepartmentDto studentDto = new StudentDepartmentDto();

            studentDto.setName(student1.getName());
            studentDto.setDepartment(Department.valueOf(student1.getDepartment().name()));
            studentDto.setEmail(student1.getEmail());
            studentDto.setAge(student1.getAge());
            studentDto.setAddress(student1.getAddress());
            studentDto.setPhoneNumber(student1.getPhoneNumber());
            studentDto.setRegistrationNo(student1.getRegistrationNo());
            studentDto.setSex(String.valueOf(student1.getSex()));
            studentDto.setState(student1.getState());

            response.add(studentDto);
        }
        return response;
    }


    @Override
    public BaseResponse findByEmail(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            return new BaseResponse<>("Student Already Exist", id);
        }
        Student student1 = student.get();
        StudentDepartmentDto studentDto = new StudentDepartmentDto();
        studentDto.setName(student1.getName());
        studentDto.setDepartment(student1.getDepartment());
        studentDto.setEmail(student1.getEmail());
        studentDto.setAge(student1.getAge());
        studentDto.setAddress(student1.getAddress());
        studentDto.setPhoneNumber(student1.getPhoneNumber());
        studentDto.setRegistrationNo(student1.getRegistrationNo());
        studentDto.setSex(String.valueOf(student1.getSex()));
        studentDto.setState(student1.getState());


        return new BaseResponse<>("Successful", studentDto);
    }

}

