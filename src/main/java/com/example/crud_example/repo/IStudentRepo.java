package com.example.crud_example.repo;

import com.example.crud_example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IStudentRepo extends JpaRepository<Student,Integer> {
}
