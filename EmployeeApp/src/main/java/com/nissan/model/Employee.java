package com.nissan.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tblEmployee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empId;
	
	@Column(nullable = false, unique = true, length=30)
	private String empName;
	
	@Column(nullable = false)
	private String designation;
	private LocalDate dateOfJoining;
	private long phoneNumber;
	
	@JoinColumn(name="deptId")
	@ManyToOne
	private Department department;
	
	// Default constructor
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Parameterized constructor
	public Employee(int empId, String empName, String designation, LocalDate dateOfJoining, long phoneNumber,
			Department department) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.designation = designation;
		this.dateOfJoining = dateOfJoining;
		this.phoneNumber = phoneNumber;
		this.department = department;
	}

	// Getters and setters
	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public LocalDate getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(LocalDate dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	// toString override
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", designation=" + designation + ", dateOfJoining="
				+ dateOfJoining + ", phoneNumber=" + phoneNumber + ", department=" + department + "]";
	}

}
