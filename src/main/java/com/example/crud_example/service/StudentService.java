package com.example.crud_example.service;

import com.example.crud_example.entity.Student;
import com.example.crud_example.exception.ResourceNotFoundException;
import com.example.crud_example.repo.IStudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService{

    private IStudentRepo studentRepo;

    @Override
    public List<Student> getStudent() {
        return studentRepo.findAll();
    }

    @Override
    public void createStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public Student findById(int id) throws ResourceNotFoundException {
        Student student = studentRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found on :: " + id));
        return student;
    }

    @Override
    public void updateStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public void deleteStudent(Student student) {
        studentRepo.delete(student);
    }


}
