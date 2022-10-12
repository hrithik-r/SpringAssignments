package com.nissan.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Professor")
public class Professor {
	// Declare fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int professorId;
	private String firstName;
	private String lastName;
	private int deptNo;
	private double salary;
	private LocalDate joinDate;
	private LocalDate dateOfBirth;
	private String gender;
	
	// Default constructor
	public Professor() {
		super();
	}

	// Parameterized Constructor
	public Professor(int professorId, String firstName, String lastName, int deptNo, double salary, LocalDate joinDate,
			LocalDate dateOfBirth, String gender) {
		super();
		this.professorId = professorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.deptNo = deptNo;
		this.salary = salary;
		this.joinDate = joinDate;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}
	
	// Parameterized constructor 2
	public Professor(String firstName, String lastName, int deptNo, double salary, LocalDate joinDate,
			LocalDate dateOfBirth, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.deptNo = deptNo;
		this.salary = salary;
		this.joinDate = joinDate;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}

	// Getters and Setters
	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	// Override
	@Override
	public String toString() {
		return "Professor [professorId=" + professorId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", deptNo=" + deptNo + ", salary=" + salary + ", joinDate=" + joinDate + ", dateOfBirth="
				+ dateOfBirth + ", gender=" + gender + "]";
	}
	
	
}
