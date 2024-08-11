package com.practice.app.spring_boot_practice.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.app.spring_boot_practice.employee.Employee;
import com.practice.app.spring_boot_practice.repository.EmployeeRepository;
import com.practice.app.spring_boot_practice.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee createEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public Optional<Employee> getEmployeeById(Long id) {
		return employeeRepository.findById(id);
	}

	@Override
	public Employee updateEmployee(Long id, Employee employeeDetails) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found"));

		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmail(employeeDetails.getEmail());

		return employeeRepository.save(employee);
	}

	@Override
	public Employee patchEmployee(Long id, Employee employeeDetails) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee nahi mila"));

		if (employeeDetails.getFirstName() != null) {
			employee.setFirstName(employeeDetails.getFirstName());
		}

		if (employeeDetails.getLastName() != null) {
			employee.setLastName(employeeDetails.getLastName());
		}

		if (employeeDetails.getEmail() != null) {
			employee.setEmail(employeeDetails.getEmail());
		}

		return employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found"));
		employeeRepository.delete(employee);
	}

}
