/**
 * 
 */
package com.comake.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.comake.domain.Employee;

/**
 * @author Jishnu Mahesh
 *
 *         Spring Data JPA Repository for Employee Entity
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
