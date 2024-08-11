package com.practice.app.spring_boot_practice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.practice.app.spring_boot_practice.employee.Employee;

public interface EmployeeService
{

	List<Employee> getAllEmployees();

	Employee createEmployee(Employee employee);

	Optional<Employee> getEmployeeById(Long id);

	Employee updateEmployee(Long id, Employee employee);

	Employee patchEmployee(Long id, Employee employeeDetails);

	void deleteEmployee(Long id);
	
	

}
