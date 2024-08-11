package com.practice.app.spring_boot_practice.service;

import java.util.List;

import com.practice.app.spring_boot_practice.employee.Employee;

public interface EmployeeService
{

	List<Employee> getAllEmployees();

	Employee createEmployee(Employee employee);
	

}
