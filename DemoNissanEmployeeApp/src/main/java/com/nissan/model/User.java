package com.nissan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tblUser")
public class User {
	// Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(nullable = false, unique = true)
	private String userName;
	
	@Column(nullable = false)
	private String password;
	private String fullName;
	private boolean isActive;
	
	@JoinColumn(name = "roleId")	// User.roleId = Role.roleId
	@ManyToOne
	private Role role;

	// Default constructor
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	// Parameterized
	public User(int userId, String userName, String password, String fullName, boolean isActive, Role role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.isActive = isActive;
		this.role = role;
	}
	
	// Getters and setters
	public int getUserId() {
		return userId;
	}

	//@JsonManagedReference
	public void setUserID(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	//@JsonBackReference // Avoid recursive object
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	// toString override
	@Override
	public String toString() {
		return "User [userID=" + userId + ", userName=" + userName + ", password=" + password + ", fullName=" + fullName
				+ ", isActive=" + isActive + ", role=" + role + "]";
	}
}
