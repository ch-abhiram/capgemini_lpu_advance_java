package com.Entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cards")
public class Card {
	
	@Id
	private Long cardId;
	private String cardName;
	private String cardType;
	private String cardNetwork;
	private LocalDate expiryDate;
	private boolean isActive;
	
	
	@ManyToMany(mappedBy = "cards")
	private List<Customer> customers;
	
	
	public Card() {}


	public Card(Long cardId, String cardName, String cardType, String cardNetwork, LocalDate expiryDate,
			boolean isActive) {
		super();
		this.cardId = cardId;
		this.cardName = cardName;
		this.cardType = cardType;
		this.cardNetwork = cardNetwork;
		this.expiryDate = expiryDate;
		this.isActive = isActive;
	}
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private BankAccount bankAccount;


	public BankAccount getBankAccount() {
		return bankAccount;
	}


	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}


	public Long getCardId() {
		return cardId;
	}


	public void setCardId(Long cardId) {
		this.cardId = cardId;
	}


	public String getCardName() {
		return cardName;
	}


	public void setCardName(String cardName) {
		this.cardName = cardName;
	}


	public String getCardType() {
		return cardType;
	}


	public void setCardType(String cardType) {
		this.cardType = cardType;
	}


	public String getCardNetwork() {
		return cardNetwork;
	}


	public void setCardNetwork(String cardNetwork) {
		this.cardNetwork = cardNetwork;
	}


	public LocalDate getExpiryDate() {
		return expiryDate;
	}


	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public List<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}


	@Override
	public String toString() {
		return "Card [cardId=" + cardId + ", cardName=" + cardName + ", cardType=" + cardType + ", cardNetwork="
				+ cardNetwork + ", expiryDate=" + expiryDate + ", isActive=" + isActive + ", customers=" + customers
				+ "]";
	}
		
}
