package com.pixel.controller;

import com.pixel.entity.Employee;
import com.pixel.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/getAllEmployees")
    public Flux<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
