package com.Entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bankaccount")
public class BankAccount {

	@Id
	private long accountId;
	private String accountNumber;
	private String accountType;
	private BigDecimal balance;
	
	public BankAccount(long accountId, String accountNumber, String accountType, BigDecimal balance) {
		super();
		this.accountId = accountId;
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
	}
	
	public BankAccount() {}
	
	@OneToMany(mappedBy = "bankAccount", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Transaction> transactions;
	
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public void addTransaction(Transaction txn) {
		transactions.add(txn);
		txn.setAcount(this);
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "BankAccount [accountId=" + accountId + ", accountNumber=" + accountNumber + ", accountType="
				+ accountType + ", balance=" + balance + ", customer=" + customer + "]";
	}
	
	
	
}
