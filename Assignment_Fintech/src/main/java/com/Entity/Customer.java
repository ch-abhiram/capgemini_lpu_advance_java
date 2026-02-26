package com.Entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {
	
	@Id
	private long customerId;
	private String fullName;
	private String email;
	private String phone;
	
	@OneToOne(mappedBy = "customer")
	private BankAccount bankAccount;
	
	@ManyToMany
	@JoinTable(name = "customer_card",
	joinColumns = @JoinColumn(name = "customer_id"),
	inverseJoinColumns = @JoinColumn(name = "card_id"))
	private List<Card> cards;
	
	
	
	
	public List<Card> getCards() {
		return cards;
	}


	public void setCards(List<Card> cards) {
		this.cards = cards;
	}


	public BankAccount getBankAccount() {
		return bankAccount;
	}


	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}


	public Customer() {}


	public Customer(long customerId, String fullName, String email, String phone) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.email = email;
		this.phone = phone;
	}


	public long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", fullName=" + fullName + ", email=" + email + ", phone=" + phone
				+ "]";
	}
	
}
