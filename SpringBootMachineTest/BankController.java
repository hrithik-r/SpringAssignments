package com.nissan.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.Bank;
import com.nissan.service.IBankService;

@RestController
@RequestMapping("api/")
public class BankController {
	// Field Injection
	@Autowired
	IBankService bankService;
	
	// Add customer
	@PostMapping("admin/customers")
	public ResponseEntity<Bank> addCustomer(@RequestBody Bank customer) {
		System.out.println("Inserting a record");
		return new ResponseEntity<Bank> (bankService.addCustomer(customer), HttpStatus.OK);
	}
	
	// Update a customer
	@PutMapping("admin/customers")
	public Bank updateCustomer(@RequestBody Bank customer) {
		System.out.println("Updating a record");
		bankService.updateCustomer(customer);
		return customer;
	}
	
	// Delete a customer
	@GetMapping("admin/customerdel/{accNumber}")
	public Bank delCustomer(@PathVariable Integer accNumber) {
		System.out.println("Deleting a record");
		return bankService.deleteCustomer(accNumber);
	}
	
	// Get all customers
	@GetMapping("admin/customers")
	List<Bank> getAllCustomers() {
		return bankService.getAllCustomers();
	}
	
	// Get a specific customer
	@GetMapping("admin/customers/{accNumber}")
	public Bank searchSpecificCustomer(@PathVariable Integer accNumber) {
		System.out.println("Retrieving a specific customer");
		return bankService.searchSpecificCustomer(accNumber);
	}
	
	// Deposit money
	@GetMapping("user/deposit/{accNumber}&{money}")
	public Double depositMoney(@PathVariable Integer accNumber, @PathVariable Double money) {
		System.out.println("Depositing money");
		return bankService.depositMoney(money, accNumber);
	}
	
	// Withdraw money
	@GetMapping("user/withdraw/{accNumber}&{money}")
	public Double withdrawMoney(@PathVariable Integer accNumber,@PathVariable Double money) {
		System.out.println("Withdrawing money");
		return bankService.withdrawMoney(money, accNumber);
	}
	
	// Show Balance
	@GetMapping("user/balance/{accNumber}")
	public Double showBalance(@PathVariable Integer accNumber) {
		System.out.println("Current balance");
		return bankService.showBalance(accNumber);
	}
	
	// Transfer money
	@GetMapping("user/transfer/{accNum1}&{accNum2}&{money}")
	public Double transferMoney(@PathVariable Integer accNum1, @PathVariable Integer accNum2, @PathVariable Double money) {
		System.out.println("Transferring money");
		return bankService.transferFunds(accNum1, accNum2, money);
	}
}
