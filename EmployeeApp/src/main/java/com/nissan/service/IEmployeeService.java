package com.nissan.service;

import java.util.List;

import com.nissan.model.Employee;

public interface IEmployeeService {
	// Retrieve all employees
	List<Employee> getAllEmployees();
	
	// Search employee by phone number
	Employee searchByPhNumber(long phoneNumber);
	
	// Add employee
	Employee addEmployee(Employee employee);
	
	// Edit employee
	Employee editEmployee(Employee employee);
}
