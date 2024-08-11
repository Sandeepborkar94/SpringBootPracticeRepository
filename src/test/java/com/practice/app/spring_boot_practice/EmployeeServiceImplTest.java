package com.practice.app.spring_boot_practice;

import com.practice.app.spring_boot_practice.employee.Employee;
import com.practice.app.spring_boot_practice.repository.EmployeeRepository;
import com.practice.app.spring_boot_practice.service.impl.EmployeeServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EmployeeServiceImplTest {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeServiceImpl employeeService;

	private Employee employee;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		employee = new Employee("John", "Doe", "john.doe@example.com");
		employee.setId(1L);
	}

	@Test
	void getAllEmployees() {
		List<Employee> employees = Arrays.asList(employee);
		when(employeeRepository.findAll()).thenReturn(employees);

		List<Employee> result = employeeService.getAllEmployees();
		assertEquals(1, result.size());
		assertEquals(employee.getFirstName(), result.get(0).getFirstName());
	}

	@Test
	void createEmployee() {
		when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

		Employee result = employeeService.createEmployee(employee);
		assertNotNull(result);
		assertEquals(employee.getFirstName(), result.getFirstName());
	}

	@Test
	void getEmployeeById() {
		when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));

		Optional<Employee> result = employeeService.getEmployeeById(employee.getId());
		assertTrue(result.isPresent());
		assertEquals(employee.getFirstName(), result.get().getFirstName());
	}

	@Test
	void updateEmployee() {
		Employee updatedEmployee = new Employee("Jane", "Doe", "jane.doe@example.com");
		when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));
		when(employeeRepository.save(any(Employee.class))).thenReturn(updatedEmployee);

		Employee result = employeeService.updateEmployee(employee.getId(), updatedEmployee);
		assertNotNull(result);
		assertEquals(updatedEmployee.getFirstName(), result.getFirstName());
	}

	@Test
	void patchEmployee() {
		Employee patchedEmployee = new Employee(null, "Smith", null);
		when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));
		when(employeeRepository.save(any(Employee.class))).thenReturn(employee);

		Employee result = employeeService.patchEmployee(employee.getId(), patchedEmployee);
		assertNotNull(result);
		assertEquals(employee.getFirstName(), result.getFirstName());
		assertEquals(patchedEmployee.getLastName(), result.getLastName());
	}

	@Test
	void deleteEmployee() {
		when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));
		doNothing().when(employeeRepository).delete(employee);

		employeeService.deleteEmployee(employee.getId());
		verify(employeeRepository, times(1)).delete(employee);
	}
}
