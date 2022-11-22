package com.pixel.controller;

import com.pixel.entity.Student;
import com.pixel.entity.Task;
import com.pixel.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    public Mono<Student> addTask(Student task) {
        task.setId(UUID.randomUUID().toString().split("-")[0]);
        return studentRepository.save(task);
    }

    @PostMapping("/add")
    public Mono<Student> addStudentRecord(@RequestBody Student student) {
       return studentRepository.save(student);
    }
}
