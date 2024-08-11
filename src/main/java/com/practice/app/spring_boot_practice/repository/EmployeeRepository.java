package com.practice.app.spring_boot_practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practice.app.spring_boot_practice.employee.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> { }
