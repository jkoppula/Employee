/**
 * 
 */
package com.comake.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.comake.domain.Employee;
import com.comake.repository.EmployeeRepository;

/**
 * @author Jishnu Mahesh
 *
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Inject
	private EmployeeRepository employeeRepository;

	private String message = null;

	private final Logger log = Logger.getLogger(EmployeeDaoImpl.class);

	/**
	 * Method to remove the Employees
	 */
	@Override
	public String removeEmployees(List<Employee> removeEmployeeList) {
		log.debug("Deleting the Employees from Database");
		employeeRepository.deleteInBatch(removeEmployeeList);
		message = "Employees removed Sucessfully : " + removeEmployeeList.size();
		return message;
	}

	/**
	 * Method to Find All Employees from the DB
	 */
	@Override
	public List<Employee> getAllEmployees() {
		log.debug("Retreving All the Employees from the DB");
		return employeeRepository.findAll();
	}

	/**
	 * Method to Insert New Employees
	 */
	@Override
	public String insertEmployees(List<Employee> insertEmployeeList) {
		List<Employee> employees = employeeRepository.save(insertEmployeeList);
		message = "Employees Inserted Sucessfully : " + employees.size();
		return message;
	}

	/**
	 * Method to Update existing Employees
	 */
	@Override
	public String UpdateEmployees(List<Employee> updateEmployeeList) {
		List<Employee> employees = employeeRepository.save(updateEmployeeList);
		message = "Employees updated Sucessfully : " + employees.size();
		return message;
	}

}
