package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.model.Employee;
import com.nissan.repo.IEmployeeRepo;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	// Field injection
	@Autowired
	IEmployeeRepo empRepo;
	
	// Show all employees' details
	@Override
	public List<Employee> getAllEmployees() {
		return (List<Employee>) empRepo.findAll();
	}

	// Search employee by phone number
	@Override
	public Employee searchByPhNumber(long phoneNumber) {
		Employee _employee = empRepo.searchByPhNumber(phoneNumber);
		if(phoneNumber==_employee.getPhoneNumber())
			return _employee;
		else
			return null;
	}

	// Add employee
	@Transactional
	@Override
	public Employee addEmployee(Employee employee) {
		return empRepo.save(employee);
	}

	@Transactional
	@Override
	public Employee editEmployee(Employee employee) {
		return empRepo.save(employee);
	}

}
