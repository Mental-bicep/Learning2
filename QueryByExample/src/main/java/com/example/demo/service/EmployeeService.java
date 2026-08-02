package com.example.demo.service;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    // Constructor Injection (Industry Best Practice)
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /**
     * Test 1: Simple Exact Match
     * Uses a probe with just the department set.
     */
    public List<Employee> findByExactDepartment(String department) {
        Employee probe = new Employee();
        probe.setDepartment(department); // Only filter by department

        // Default Matcher: Looks for exact matches on non-null fields
        Example<Employee> example = Example.of(probe);
        
        return employeeRepository.findAll(example);
    }

    /**
     * Test 2: Advanced Dynamic Search
     * Accepts a populated object from the Controller and applies custom matching rules.
     */
    public List<Employee> dynamicSearch(Employee searchCriteria) {
        // Create a custom ExampleMatcher to configure HOW things should match
        ExampleMatcher customMatcher = ExampleMatcher.matching()
                // If they provide any string, check if it CONTAINS the text (instead of exact match)
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                // Ignore case (e.g., "it" matches "IT")
                .withIgnoreCase()
                // Ignore null values (don't try to query where firstName is null)
                .withIgnoreNullValues()
                // Ignore primitive defaults (like id=0) so it doesn't mess up the query
                .withIgnorePaths("id");

        // Combine the user's search criteria with our custom rules
        Example<Employee> example = Example.of(searchCriteria, customMatcher);
        
        return employeeRepository.findAll(example);
    }
}