package com.School.repository;

import com.School.model.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<School, Long> {

}
