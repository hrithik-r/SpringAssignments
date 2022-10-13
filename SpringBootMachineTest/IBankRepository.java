package com.nissan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.nissan.model.Bank;

@Repository
public interface IBankRepository extends JpaRepositoryImplementation<Bank, Integer> {
	@Query("from Bank where accNumber=?1")
	public Bank searchSpecificCustomer(Integer accNumber);
}
