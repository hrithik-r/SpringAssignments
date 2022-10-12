package com.nissan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.User;

@Repository
public interface IUserRepository extends JpaRepositoryImplementation<User, Integer> {
	// Spring Data JPA --JpaRepositoryImplementation, CrudRepository
	// CustomRetrieve username and password
	@Query("from User where userName=?1 and password=?2 and isActive=true")
	public User findByUserNameAndPassword(String userName, String password);
	
	@Query("from User where fullName=?1 and isActive=true")
	public User findByFullName(String fullName);
}
