package com.nissan.service;

import java.util.List;

import com.nissan.model.Bank;

public interface IBankService {
	// Add customer
	Bank addCustomer(Bank customer);
	
	// Updating a customer
	Bank updateCustomer(Bank customer);
	
	// Delete a customer
	Bank deleteCustomer(Integer accNumber);
	
	// Get all customers
	List<Bank> getAllCustomers();
	
	// Get a specific customer
	Bank searchSpecificCustomer(Integer accNumber);
	
	// Deposit Money
	Double depositMoney(Double money, Integer accNumber);
	
	// Withdraw money
	Double withdrawMoney(Double money, Integer accNumber);
	
	// Show balance
	Double showBalance(Integer accNumber);
	
	// Transfer money
	Double transferFunds(Integer accNum1, Integer accNum2, Double money);
}
