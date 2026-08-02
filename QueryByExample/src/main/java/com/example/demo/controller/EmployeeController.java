package com.example.demo.controller;

import com.example.demo.domain.Employee;
import com.example.demo.service.EmployeeService;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // Endpoint 1: Exact Match (GET)
    // Test URL: http://localhost:8080/api/employees/department/IT
    @GetMapping("/department/{department}")
    public List<Employee> getEmployeesByDepartment(@PathVariable String department) {
        return employeeService.findByExactDepartment(department);
    }

    // Endpoint 2: Advanced QBE Search (POST)
    // This perfectly demonstrates QBE! You can send JSON with 1 field, or 3 fields, 
    // and the backend dynamically builds the query without crashing.
    @PostMapping("/search")
    public List<Employee> searchEmployees(@RequestBody Employee searchCriteria) {
        return employeeService.dynamicSearch(searchCriteria);
    }
}