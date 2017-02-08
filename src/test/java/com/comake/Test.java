package com.comake;

import java.util.ArrayList;
import java.util.List;

import com.comake.domain.Employee;
import com.comake.service.EmployeeServiceImpl;

public class Test {

	public static void main(String[] args) {
		List<Employee> emplist = new ArrayList<>();
		Employee e = new Employee();
		Employee e1 = new Employee();
		Employee e2 = new Employee();
		Employee e3 = new Employee();
		e.setEmployeeCode(001);
		e.setDepartmentName("test");
		e.setEmployeeName("test");
		e.setPhoneNumber("1234567899");
		e1.setEmployeeCode(002);
		e1.setDepartmentName("test");
		e1.setEmployeeName("test");
		e1.setPhoneNumber("1234567899");
		e2.setEmployeeCode(001);
		e2.setDepartmentName("test1");
		e2.setEmployeeName("test");
		e2.setPhoneNumber("1234567899");
		e3.setEmployeeCode(003);
		e3.setDepartmentName("test");
		e3.setEmployeeName("test");
		e3.setPhoneNumber("1234567899");

		emplist.add(e);
		emplist.add(e1);
		emplist.add(e2);
		emplist.add(e3);
		System.out.println("List Size" + emplist.size());
		EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
		employeeService.mergeEmployeeList(emplist);
	}

}
