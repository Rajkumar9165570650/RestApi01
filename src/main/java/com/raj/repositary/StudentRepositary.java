package com.raj.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raj.entity.Student;

@Repository
public interface StudentRepositary extends JpaRepository<Student, Integer>{

}
