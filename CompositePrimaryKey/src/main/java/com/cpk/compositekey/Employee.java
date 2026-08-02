package com.cpk.compositekey;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

/**
 * Step 2: Use the composite key in your Entity with @EmbeddedId
 */
@Entity
public class Employee {
	
		
	@EmbeddedId
    private EmployeeId id; // This is the composite key

    private String name;
    private String designation;

    // Default constructor
    public Employee() {
    }

    // Getters and Setters
    public EmployeeId getId() {
        return id;
    }

    public void setId(EmployeeId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}