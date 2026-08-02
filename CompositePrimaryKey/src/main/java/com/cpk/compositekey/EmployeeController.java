package com.cpk.compositekey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create a new Employee
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get all Employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get a specific Employee by their Composite Key
    @GetMapping("/{deptId}/{empId}")
    public Employee getEmployeeById(@PathVariable Long deptId, @PathVariable Long empId) {
        EmployeeId compositeId = new EmployeeId(deptId, empId);
        
        return employeeRepository.findById(compositeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }
}