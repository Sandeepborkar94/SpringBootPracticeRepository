package com.practice.app.spring_boot_practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.app.spring_boot_practice.employee.Employee;
import com.practice.app.spring_boot_practice.service.EmployeeService;

@RestController
@RequestMapping("api/employees")
public class EmployeeController 
{
	
	@Autowired EmployeeService employeeService; 
	
	public Employee createEmployee(@RequestBody Employee employee) 
	{
		
		return employeeService.createEmployee(employee);
		
	}
	
	
	public List<Employee> getAllEmployees()
	{
		return employeeService.getAllEmployees();
	}

}
