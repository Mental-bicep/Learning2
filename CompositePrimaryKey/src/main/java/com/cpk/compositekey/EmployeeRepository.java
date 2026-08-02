package com.cpk.compositekey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Note that the ID type passed to JpaRepository is our composite key class 'EmployeeId'
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, EmployeeId> {
    
}