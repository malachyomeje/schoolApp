package com.School.service.schoolServiceimpl;

import com.School.dto.request.StudentDepartmentDto;
import com.School.dto.request.StudentDto;
import com.School.dto.response.ApiResponse;
import com.School.dto.response.BaseResponse;
import com.School.enums.Department;
import com.School.enums.Faculty;
import com.School.enums.Sex;
import com.School.schoolModel.School;
import com.School.repository.SchoolRepository;
import com.School.service.SchoolService;
import com.School.utils.SchoolUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SchoolServiceImp implements SchoolService {

    private final SchoolRepository schoolRepository;


    @Override
    public BaseResponse registerStudent(StudentDto studentDto) {
        Optional<School> student = schoolRepository.findByEmail(studentDto.getEmail());

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


        School school1 = School.builder()
                .name(studentDto.getName())
                .faculty(faculty)
                .department(department)
                .email(studentDto.getEmail())
                .age(studentDto.getAge())
                .address(studentDto.getAddress())
                .phoneNumber(studentDto.getPhoneNumber())
                .registrationNo(SchoolUtils.generateRegNo(studentDto.getDepartment()))
                .sex(sex)
                .state(studentDto.getState())
                .nameOfParent(studentDto.getNameOfParent())
                .parentPhoneNo(studentDto.getParentPhoneNo())
                .parentAddress(studentDto.getParentAddress())
                .build();
        schoolRepository.save(school1);
        return new BaseResponse<>("registration successful", school1);
    }

    @Override
    public List<StudentDto> findAllStudent() {
        List<School> list = schoolRepository.findAll();
        List<StudentDto> student = new ArrayList<>();

        for (School school1 : list) {

            StudentDto studentDto1 = new StudentDto();
            studentDto1.setName(school1.getName());
            studentDto1.setFaculty(String.valueOf(school1.getFaculty()));
            studentDto1.setDepartment(school1.getDepartment().name());
            studentDto1.setEmail(school1.getEmail());
            studentDto1.setAge(school1.getAge());
            studentDto1.setAddress(school1.getAddress());
            studentDto1.setPhoneNumber(school1.getPhoneNumber());
            studentDto1.setRegistrationNo(school1.getRegistrationNo());
            studentDto1.setSex(String.valueOf(school1.getSex()));
            studentDto1.setState(school1.getState());
            studentDto1.setNameOfParent(school1.getNameOfParent());
            studentDto1.setParentPhoneNo(school1.getParentPhoneNo());
            studentDto1.setParentAddress(school1.getParentAddress());

            student.add(studentDto1);
        }
        return student;
    }


    @Override
    public List<StudentDepartmentDto> findAllStudentByDepartment(Department department) {
        Department department2 = SchoolUtils.department7(department.name());
        if (department2 == null) {
            throw new RuntimeException("you are  mad");
        }

        List<School> department1 = schoolRepository.findAllByDepartment(department);
        List<StudentDepartmentDto> response = new ArrayList<>();

        for (School school1 : department1) {

            StudentDepartmentDto studentDto = new StudentDepartmentDto();

            studentDto.setName(school1.getName());
            studentDto.setDepartment(Department.valueOf(school1.getDepartment().name()));
            studentDto.setEmail(school1.getEmail());
            studentDto.setAge(school1.getAge());
            studentDto.setAddress(school1.getAddress());
            studentDto.setPhoneNumber(school1.getPhoneNumber());
            studentDto.setRegistrationNo(school1.getRegistrationNo());
            studentDto.setSex(String.valueOf(school1.getSex()));
            studentDto.setState(school1.getState());

            response.add(studentDto);
        }
        return response;
    }


    @Override
    public BaseResponse findById(Long id) {
        Optional<School> student = schoolRepository.findById(id);
        if (student.isEmpty()) {
            return new BaseResponse<>("Student Already Exist", id);
        }
        School school1 = student.get();
        StudentDepartmentDto studentDto = new StudentDepartmentDto();
        studentDto.setName(school1.getName());
        studentDto.setDepartment(school1.getDepartment());
        studentDto.setEmail(school1.getEmail());
        studentDto.setAge(school1.getAge());
        studentDto.setAddress(school1.getAddress());
        studentDto.setPhoneNumber(school1.getPhoneNumber());
        studentDto.setRegistrationNo(school1.getRegistrationNo());
        studentDto.setSex(String.valueOf(school1.getSex()));
        studentDto.setState(school1.getState());


        return new BaseResponse<>("Successful", studentDto);
    }

    @Override
    public ApiResponse<List<School>> sorting(String name) {
        List<School> sortingSchool = schoolRepository.findAll(Sort.by(Sort.Direction.ASC, name));
        return new ApiResponse<>(sortingSchool.size(), sortingSchool);
    }

    @Override
    public ApiResponse<Page<School>> page(int offset, int pageSize) {
        Page<School> paging = schoolRepository.findAll(PageRequest.of(offset,pageSize));
        return new ApiResponse<>(paging.getSize(), paging);
    }


}

