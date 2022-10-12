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

import com.nissan.model.User;
import com.nissan.service.IUserService;

@RestController
@RequestMapping("api/")
public class UserController {
	// Field DI
	@Autowired
	IUserService userService;
	
	// List all users
	@GetMapping("users")
	public List<User> findAllUsers(){
		return userService.findAllUsers();
	}
	
	// Get user by username and password
	@GetMapping("users/{userName}&{password}")
	public User findUserByNameAndPassword(@PathVariable String userName, @PathVariable String password) {
		System.out.println("Inside the controller");
		return userService.findByUserNameAndPassword(userName, password);
		
	}
	
	// Get user by full name
	@GetMapping("users/{fullName}")
	public User findByFullName(@PathVariable String fullName) {
		System.out.println("Inside the controller");
		return userService.findByFullName(fullName);
	}
	
	// Add user
	@PostMapping("users")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		System.out.println("Inserting a record");
		return new ResponseEntity<User> (userService.addUser(user),HttpStatus.OK);
	}
	
	// Update user
	@PutMapping("users")
	public User updateUser(@RequestBody User user) {
		System.out.println("Updating a record");
		userService.updateUser(user);
		return user;
	}
	
}
