package com.School.repository;

import com.School.enums.Department;
import com.School.enums.Faculty;
import com.School.schoolModel.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SchoolRepository extends JpaRepository<School, Long> {

    Optional<School> findByEmail(String email);

   List<School>findAllByDepartment(Department department);

    Optional<School>findAllByFaculty(Faculty faculty);

    Optional<School>findByRegistrationNo(String registration );
}
