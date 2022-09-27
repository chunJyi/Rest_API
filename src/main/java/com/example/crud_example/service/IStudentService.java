package com.example.crud_example.service;

import com.example.crud_example.entity.Student;
import com.example.crud_example.exception.ResourceNotFoundException;

import java.util.List;

public interface IStudentService {
    List<Student> getStudent();

    void createStudent(Student student);

    Student findById(int id) throws ResourceNotFoundException;

    void updateStudent(Student student);

    void deleteStudent(Student student);
}
