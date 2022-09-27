package com.example.crud_example.controller;

import com.example.crud_example.entity.Student;
import com.example.crud_example.exception.ResourceNotFoundException;
import com.example.crud_example.service.IStudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("student")
public class StudentController {

    private IStudentService studentService;

    @GetMapping()
    public ResponseEntity<?> getStudents(){
        return  ResponseEntity.status(HttpStatus.OK).body(studentService.getStudent());
    }

    @PostMapping()
    public ResponseEntity<?> createStudent(@Valid @RequestBody Student student , BindingResult result){
        if(result.hasErrors()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.getFieldError().getDefaultMessage());
        }
        studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable(name = "id") int id) {
        Student student = null;
        try {
            student=studentService.findById(id);
        }
        catch (ResourceNotFoundException exception)
        {
          return   ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
      return ResponseEntity.ok().body(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> UpdateStudent(@PathVariable(name = "id") int id,@Valid @RequestBody Student stu) {
        Student student = null;
        try {
            student=studentService.findById(id);
        }catch (ResourceNotFoundException exception){
            return   ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
        student.setFirstName(stu.getFirstName());
        student.setLastName(stu.getLastName());
        student.setEmail(stu.getEmail());
        student.setPhNo(stu.getPhNo());
        studentService.updateStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(stu);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> DeleteStudent(@PathVariable (name = "id") int id){
        Student student = null;
        try {
            student=studentService.findById(id);
        }catch (ResourceNotFoundException exception){
            return   ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
        studentService.deleteStudent(student);
       return ResponseEntity.status(HttpStatus.OK).body(student);
    }
}
