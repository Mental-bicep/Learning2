package com.example.demo.bootstrap;

import com.example.demo.domain.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository repository;

    public DataLoader(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Seed the database on application startup
        repository.save(new Employee("Alice", "Smith", "IT", "Backend Developer"));
        repository.save(new Employee("Bob", "Smith", "HR", "Recruiter"));
        repository.save(new Employee("Charlie", "Brown", "IT", "Frontend Developer"));
        repository.save(new Employee("Diana", "Prince", "Finance", "Data Analyst"));
        
        System.out.println("✅ Dummy Data Loaded Successfully!");
    }
}