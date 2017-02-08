/**
 * 
 */
package com.comake.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.comake.dao.EmployeeDao;
import com.comake.domain.Employee;

/**
 * @author Jishnu Mahesh
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Inject
	private EmployeeDao employeeDao;

	private final Logger log = Logger.getLogger(EmployeeServiceImpl.class);

	/**
	 * Method to Check And Update and remove the Employees
	 * 
	 * @param employeeList
	 * @return
	 */
	public String mergeEmployeeList(List<Employee> employeeList) {

		String message = null;
		String insertMessage = null;
		String updateMessage = null;
		String deleteMessage = null;
		// removing duplicates from the list
		List<Employee> employees = employeeList.stream().distinct().collect(Collectors.toList());

		List<Employee> insertEmployeeList = new ArrayList<>();
		List<Employee> updateEmployeeList = new ArrayList<>();
		List<Employee> removeEmployeeList = new ArrayList<>();

		log.debug("Getting All the Employees from the DB");
		List<Employee> dbEmployeeList = employeeDao.getAllEmployees();

		// Iterating the list to add the employees that received from system
		for (Employee employee : employees) {

			if (dbEmployeeList.contains(employee)) {
				log.debug("Adding Existing Employees to the List");
				updateEmployeeList.add(employee);
			} else {
				log.debug("Adding New Employees to the List");
				insertEmployeeList.add(employee);
			}
		}
		log.debug("Inserting New Employees that recevied from System");
		insertMessage = employeeDao.insertEmployees(insertEmployeeList);
		log.debug("Updateing Existing Employees that recevied from System");
		updateMessage = employeeDao.UpdateEmployees(updateEmployeeList);

		// Iterating the existing database employees and adding to list
		for (Employee employee : dbEmployeeList) {
			if (!employees.contains(employee)) {
				log.debug("Adding DB Employees that need to be removed to the List");
				removeEmployeeList.add(employee);
			}
		}
		log.debug("Removing Existing Employees that not available from System");
		deleteMessage = employeeDao.removeEmployees(removeEmployeeList);
		message = insertMessage + "\n" + updateMessage + "\n" + deleteMessage;
		return message;
	}

}
