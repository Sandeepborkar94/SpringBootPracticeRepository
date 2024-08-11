package com.practice.app.spring_boot_practice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practice.app.spring_boot_practice.employee.Employee;
import com.practice.app.spring_boot_practice.service.EmployeeService;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {

		return employeeService.createEmployee(employee);

	}

	@GetMapping
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable Long id) {
		return employeeService.getEmployeeById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		return ResponseEntity.ok(employeeService.updateEmployee(id, employee));
	}

	@PatchMapping("/{id}")
	public ResponseEntity<Employee> patchEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
		return ResponseEntity.ok(employeeService.patchEmployee(id, employeeDetails));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployee(id);
		return ResponseEntity.noContent().build();
	}

}
