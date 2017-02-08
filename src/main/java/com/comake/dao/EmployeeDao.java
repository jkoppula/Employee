/**
 * 
 */
package com.comake.dao;

import java.util.List;

import com.comake.domain.Employee;

/**
 * @author Jishnu Mahesh
 *
 */
public interface EmployeeDao {

	public List<Employee> getAllEmployees();

	public String insertEmployees(List<Employee> insertEmployeeList);

	public String UpdateEmployees(List<Employee> updateEmployeeList);

	public String removeEmployees(List<Employee> removeEmployeeList);
}
