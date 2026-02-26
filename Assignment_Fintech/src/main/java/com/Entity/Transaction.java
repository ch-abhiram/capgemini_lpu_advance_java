package com.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transactions")
public class Transaction {
	
	@Id
	private long transactionId;
	private String txnType;
	private BigDecimal amount;
	private LocalDateTime txnDate;
	private String description;
	private String referenceNumber;
	
	public Transaction(long transactionId, String txnType, BigDecimal amount, LocalDateTime txnDate, String description,
			String referenceNumber) {
		super();
		this.transactionId = transactionId;
		this.txnType = txnType;
		this.amount = amount;
		this.txnDate = txnDate;
		this.description = description;
		this.referenceNumber = referenceNumber;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private BankAccount bankAccount;
	
	
	
	public long getTransactionId() {
		return transactionId;
	}



	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}



	public String getTxnType() {
		return txnType;
	}



	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}



	public BigDecimal getAmount() {
		return amount;
	}



	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}



	public LocalDateTime getTxnDate() {
		return txnDate;
	}



	public void setTxnDate(LocalDateTime txnDate) {
		this.txnDate = txnDate;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getReferenceNumber() {
		return referenceNumber;
	}



	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}



	public BankAccount getAcount() {
		return bankAccount;
	}



	public void setAcount(BankAccount acount) {
		this.bankAccount = acount;
	}



	public Transaction() {}	
	
}