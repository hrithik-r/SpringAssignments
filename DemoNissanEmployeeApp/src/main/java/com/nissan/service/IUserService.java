package com.nissan.service;

import java.util.List;

import com.nissan.model.User;

public interface IUserService {
	// Find all users
	List<User> findAllUsers();
	
	// Find user by username and password
	User findByUserNameAndPassword(String userName, String password);
	
	// Find user by full name
	User findByFullName(String fullName);
	
	// Insert user
	User addUser(User user);
	
	// Update user
	User updateUser(User user);
	
}
