package com.School.repository;

import com.School.libraryModel.Category;
import com.School.libraryModel.LibraryStudent;
import com.School.schoolModel.School;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibraryStudentRepository extends JpaRepository<LibraryStudent, Long> {

    Optional<LibraryStudent> findByEmail(String email);

}
