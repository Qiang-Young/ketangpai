package com.example.classchoolsp.repository;

import com.example.classchoolsp.entity.Class;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRepository extends JpaRepository<Class, String> {
}
