package com.School.repository;

import com.School.enums.Department;
import com.School.enums.Faculty;
import com.School.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student>findAllByEmail(String email);

   List<Student>findAllByDepartment(Department department);

    Optional<Student>findAllByFaculty(Faculty faculty);

    Optional<Student>findByRegistrationNo(String registration );
}
