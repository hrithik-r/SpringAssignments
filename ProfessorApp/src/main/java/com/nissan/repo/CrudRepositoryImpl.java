package com.nissan.repo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.nissan.model.Professor;

public class CrudRepositoryImpl implements ICrudRepository {

	public void insertEntity() {
		// EntityManagerFactory
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		Scanner input = new Scanner(System.in);
		
		try {
			emf = Persistence.createEntityManagerFactory("DemoEmployeeDB");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			
			// Start transaction
			transaction.begin();
			
			// Create an object of professor
			Professor professor = new Professor();
			
			// Get input from the user
			System.out.println("Enter the first name: ");
			professor.setFirstName(input.nextLine());
			System.out.println("Enter the last name: ");
			professor.setLastName(input.nextLine());
			System.out.println("Enter the department number: ");
			professor.setDeptNo(Integer.parseInt(input.nextLine()));
			System.out.println("Enter the salary: ");
			professor.setSalary(Double.parseDouble(input.nextLine()));
			System.out.println("Enter the joining date(yyyy-mm-dd): ");
			professor.setJoinDate(LocalDate.parse(input.nextLine()));
			System.out.println("Enter the date of birth(yyyy-mm-dd): ");
			professor.setDateOfBirth(LocalDate.parse(input.nextLine()));
			System.out.println("Enter your gender: ");
			professor.setGender(input.nextLine());
			
			// ORM
			entityManager.persist(professor);
			
			// DB
			transaction.commit();
		} catch(Exception ex) {
			transaction.rollback();
		} finally {
			emf.close();
			input.close();
		}
	}

	public void listEntity() {
		// Entity Manager Factory
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("DemoEmployeeDB");
			entityManager = emf.createEntityManager();
			
			// List of professors
			// JPQL - Java Persistence Query Language
			List<Professor> professors = entityManager.createQuery("from Professor").getResultList();
			for (Professor professor : professors) {
				System.out.println("ProfessorId: "+professor.getProfessorId());
				System.out.println("First Name: "+professor.getFirstName());
				System.out.println("Last Name: "+professor.getLastName());
				System.out.println("Dept. No.: "+professor.getDeptNo());
				System.out.println("Salary: "+professor.getSalary());
				System.out.println("Joining Date: "+professor.getJoinDate());
				System.out.println("DOB: "+professor.getDateOfBirth());
				System.out.println("Gender: "+professor.getGender());
			}		
			
		} catch(Exception ex) {
			
		} finally {
			
		}
	}

	
	public void editEntity() {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		Scanner input = new Scanner(System.in);
		
		try {
			emf = Persistence.createEntityManagerFactory("DemoEmployeeDB");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			
			// Search
			System.out.println("Enter the Id: ");
			int id = Integer.parseInt(input.nextLine());
			
			// Select from entityManager
			Professor pro = entityManager.find(Professor.class, id);
			
			// Change first and last name
			System.out.println("Enter the first name: ");
			pro.setFirstName(input.nextLine());
			System.out.println("Enter the last name: ");
			pro.setLastName(input.nextLine());
			
			// Commit
			entityManager.getTransaction().commit();
			
			// After update
			System.out.println(pro);
		} catch(Exception ex) {
			transaction.rollback();
		} finally {
			emf.close();
			input.close();
		}
	}

	public void deleteEntity() {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		Scanner input = new Scanner(System.in);
		
		try {
			emf = Persistence.createEntityManagerFactory("DemoEmployeeDB");
			entityManager = emf.createEntityManager();
			transaction = entityManager.getTransaction();
			
			// Search
			System.out.println("Enter the Id: ");
			int id = Integer.parseInt(input.nextLine());
			
			Professor pro = entityManager.find(Professor.class, id);
			
		} catch(Exception ex) {
			transaction.rollback();
		} finally {
			emf.close();
		}
	}

	public Optional<Professor> searchEntity(String name) {
		EntityManagerFactory emf = null;
		EntityManager entityManager = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("DemoEmployeeDB");
			entityManager = emf.createEntityManager();
			
			// List of professor
			// JPQL - Java Persistence Query Language
			Professor professor = entityManager.createQuery("SELECT p FROM Professor p WHERE p.firstName=:name",Professor.class)
					.setParameter("name", name).getSingleResult();
			return (Optional<Professor>) (professor != null ? Optional.of(professor) : Optional.empty());
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			emf.close();
		}
	}

}
