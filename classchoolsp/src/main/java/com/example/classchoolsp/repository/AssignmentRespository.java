package com.example.classchoolsp.repository;

import com.example.classchoolsp.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRespository extends JpaRepository<Assignment, String> {
}
