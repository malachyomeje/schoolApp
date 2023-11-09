package com.School.repository;

import com.School.enums.Department;
import com.School.enums.Faculty;
import com.School.model.Library;
import com.School.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LibraryRepository extends JpaRepository<Library, Long> {


}
