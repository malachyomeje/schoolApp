package com.School.repository;

import com.School.model.Category;
import com.School.model.Library;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {



}
