package com.nissan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.Employee;
import com.nissan.service.IEmployeeService;

@RestController
@RequestMapping("api/")
public class EmployeeController {
	//DI
	@Autowired
	IEmployeeService empService;
	
	@GetMapping("employees")
	List<Employee> getAllEmployees(){
		return empService.getAllEmployees();
	}
	
	@GetMapping("employees/{phoneNumber}")
	public Employee searchByPhNumber(@PathVariable long phoneNumber) {
		System.out.println("Inside the controller");
		return empService.searchByPhNumber(phoneNumber);
	}
	
	// Add employee
	@PostMapping("employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		System.out.println("Inserting a record");
		return new ResponseEntity<Employee> (empService.addEmployee(employee),HttpStatus.OK);
	}
	
	// Edit employee
	@PutMapping("employees")
	public Employee editEmployee(@RequestBody Employee employee) {
		System.out.println("Updating a employee");
		empService.editEmployee(employee);
		return employee;
	}
}
