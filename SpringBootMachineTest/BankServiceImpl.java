package com.nissan.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.model.Bank;
import com.nissan.repo.IBankRepository;

@Service
public class BankServiceImpl implements IBankService {
	// Field Injection
	@Autowired
	IBankRepository bankRepo;
	
	// Add a customer
	@Transactional
	@Override
	public Bank addCustomer(Bank customer) {
		return bankRepo.save(customer);
	}
	
	// Update a customer
	@Transactional
	@Override
	public Bank updateCustomer(Bank customer) {
		return bankRepo.save(customer);
	}
	
	// Delete a particular customer
	@Override
	public Bank deleteCustomer(Integer accNumber) {
		Bank _customer = bankRepo.searchSpecificCustomer(accNumber);
		if(accNumber==_customer.getAccNumber()) {
			_customer.setIsActive(false);
			return _customer;
		}
		else
			return null;
	}

	// Get all customers
	@Override
	public List<Bank> getAllCustomers() {
		return (List<Bank>) bankRepo.findAll();
	}

	// Get a specific customer
	@Override
	public Bank searchSpecificCustomer(Integer accNumber) {
		Bank _customer = bankRepo.searchSpecificCustomer(accNumber);
		if(accNumber==_customer.getAccNumber())
			return _customer;
		else
			return null;
	}

	// Deposit
	@Override
	public Double depositMoney(Double money, Integer accNumber) {
		Bank _customer = bankRepo.searchSpecificCustomer(accNumber);
		if(accNumber==_customer.getAccNumber()) {
			_customer.depositMoney(money);
			return _customer.getBalance();
		}
		else
			return null;
	}
	
	// Withdraw money
	@Override
	public Double withdrawMoney(Double money, Integer accNumber) {
		Bank _customer = bankRepo.searchSpecificCustomer(accNumber);
		if(accNumber==_customer.getAccNumber()) {
			_customer.withdrawMoney(money);
			return _customer.getBalance();
		}
		else
			return null;
	}
	
	// Show balance
	@Override
	public Double showBalance(Integer accNumber) {
		Bank _customer = bankRepo.searchSpecificCustomer(accNumber);
		if(accNumber==_customer.getAccNumber())
			return _customer.getBalance();
		else
			return null;
	}

	// Transfer funds
	@Override
	public Double transferFunds(Integer accNum1, Integer accNum2, Double money) {
		Bank _customer1 = bankRepo.searchSpecificCustomer(accNum1);
		Bank _customer2 = bankRepo.searchSpecificCustomer(accNum2);
		if(accNum1==_customer1.getAccNumber() && accNum2==_customer2.getAccNumber()) {
			_customer1.withdrawMoney(money);
			_customer2.depositMoney(money);
			return _customer1.getBalance();
		}
		else
			return null;
	}
	
}
