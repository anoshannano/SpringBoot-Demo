package com.example.demo.web;

import com.example.demo.repository.StudentRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.Student;
@RequestMapping("/api")
@RestController
public class StudentController {
    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/insert-student")
    public Student insertStudent(@RequestBody Student student){
        studentRepository.save(student);
        return student;
    }
}
