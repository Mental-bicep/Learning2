package com.cpk.compositekey;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * Step 1: Create a class for the composite key and annotate it with @Embeddable.
 * It MUST implement Serializable and override equals() and hashCode().
 */
@Embeddable
public class EmployeeId implements Serializable {

    private Long departmentId;
    private Long employeeId;

    // Default constructor is mandatory for JPA
    public EmployeeId() {
    }

    public EmployeeId(Long departmentId, Long employeeId) {
        this.departmentId = departmentId;
        this.employeeId = employeeId;
    }

    // Getters and Setters
    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    // equals() and hashCode() are required for Composite Keys in Hibernate/JPA
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeId that = (EmployeeId) o;
        return Objects.equals(departmentId, that.departmentId) &&
               Objects.equals(employeeId, that.employeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, employeeId);
    }
}