package com.nissan.model;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblBank")
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer custId;
	
	@Column(unique = true)
	private Integer accNumber;
	
	@Column(nullable = false)
	private String custName;
	private String accType;
	private Double balance;
	private Double minBalance;
	private Long mobNumber;
	private String emailId;
	private Integer atmPin;
	private Boolean isActive;
	
	// Default constructor
	public Bank() {
		super();
	}

	// Parameterized constructor
	public Bank(Integer custId, Integer accNumber, String custName, String accType, Double balance, Double minBalance,
			Long mobNumber, String emailId, Integer atmPin, Boolean isActive) {
		super();
		this.custId = custId;
		this.accNumber = accNumber;
		this.custName = custName;
		this.accType = accType;
		this.balance = balance;
		this.minBalance = minBalance;
		this.mobNumber = mobNumber;
		this.emailId = emailId;
		this.atmPin = atmPin;
		this.isActive= isActive;
	}

	// Getters and setters
	public Integer getAccNumber() {
		return accNumber;
	}

	public void setAccNumber(Integer accNumber) {
		this.accNumber = generateAccNumber();
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getMinBalance() {
		return minBalance;
	}

	public void setMinBalance(Double minBalance) {
		this.minBalance = minBalance;
	}

	public Long getMobNumber() {
		return mobNumber;
	}

	public void setMobNumber(Long mobNumber) {
		this.mobNumber = mobNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Integer getAtmPin() {
		return atmPin;
	}

	public void setAtmPin(Integer atmPin) {
		this.atmPin = generateATMPin();
	}
	
	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	// toString override
	@Override
	public String toString() {
		return "Bank [custId=" + custId + ", accNumber=" + accNumber + ", custName=" + custName + ", accType=" + accType
				+ ", balance=" + balance + ", minBalance=" + minBalance + ", mobNumber=" + mobNumber + ", emailId="
				+ emailId + ", atmPin=" + atmPin + "]";
	}
	
	// Custom methods
	private Integer generateAccNumber() {
		Random random = new Random();
		return 100000000 + random.nextInt(900000000);
	}

	private Integer generateATMPin() {
		Random random = new Random();
		return 1000 + random.nextInt(9000);
	}
	
	public void depositMoney(Double money) {
		this.balance = balance+money;
	}
	
	public void withdrawMoney(Double money) {
		if(money>(balance-minBalance))
			this.balance = balance-money;
		else
			System.out.println("Insufficient funds!");
	}
}
