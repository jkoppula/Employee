package com.comake;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.comake.dao.EmployeeDaoImpl;
import com.comake.domain.Employee;
import com.comake.repository.EmployeeRepository;
import com.comake.service.EmployeeServiceImpl;

/**
 * 
 * @author Jishnu Mahesh
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackageClasses = Employee.class)
public class EmployeeApplication {

	/**
	 * Bean to Register H2
	 * 
	 * @return
	 */
	@Bean
	public ServletRegistrationBean h2servletRegistration() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
		registration.addUrlMappings("/h2-console/*");
		return registration;
	}

	/**
	 * Bean {@link EmployeeServiceImpl}
	 * 
	 * @return
	 */
	@Bean
	public EmployeeServiceImpl employeeServiceImpl() {
		EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();

		return employeeServiceImpl;
	}

	/**
	 * Bean {@link EmployeeDaoImpl}
	 * 
	 * @return
	 */
	public EmployeeDaoImpl employeeDaoImpl() {
		return new EmployeeDaoImpl();
	}

	/**
	 * Run the Spring application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}
}
