package com.nissan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.Employee;

@Repository
public interface IEmployeeRepo extends JpaRepositoryImplementation<Employee, Integer> {
	@Query("from Employee where phoneNumber=?1")
	public Employee searchByPhNumber(long phoneNumber);
}
