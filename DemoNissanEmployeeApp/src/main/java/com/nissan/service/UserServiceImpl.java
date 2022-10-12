package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.model.User;
import com.nissan.repo.IUserRepository;

@Service
public class UserServiceImpl implements IUserService {
	// Field injection
	@Autowired
	IUserRepository userRepo;
	
	/*@Autowired
	public UserServiceImpl(IUserRepository _userRepo) {
		this.userRepo = _userRepo;
	}*/
	
	@Override
	public List<User> findAllUsers() {
		return (List<User>) userRepo.findAll();
	}

	@Override
	public User findByUserNameAndPassword(String userName, String password) {
		User _user = userRepo.findByUserNameAndPassword(userName, password);
		
		// Check condition
		if(userName.equals(_user.getUserName()) && password.equals(_user.getPassword()))
			return _user;
		else
			return null;
	}

	@Override
	public User findByFullName(String fullName) {
		User _user = userRepo.findByFullName(fullName);
		if(fullName.equals(_user.getFullName()))
			return _user;
		else
			return null;
	}

	@Transactional
	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}

	@Transactional
	@Override
	public User updateUser(User user) {
		return userRepo.save(user);
	}

}
