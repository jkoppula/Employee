package com.comake.rest;

import java.util.List;
import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comake.domain.Employee;
import com.comake.service.EmployeeServiceImpl;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author Jishnu Mahesh
 *
 */
@RestController
@RequestMapping("/api")
public class EmployeeRest {

	@Inject
	private EmployeeServiceImpl employeeService;

	private final Logger log = Logger.getLogger(EmployeeRest.class);

	/**
	 * 
	 * @param employeeList
	 * @return
	 */
	@RequestMapping(value = "/employeeList", method = RequestMethod.POST)
	public @ResponseBody String employeeRecords(@RequestBody List<Employee> employeeList) {
		String message = null;
		log.debug("Calling Employee Service to Check and Update the Employee List");
		message = employeeService.mergeEmployeeList(employeeList);
		return message;
	}

}
