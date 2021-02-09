package com.example.disruptive.transaction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.example.disruptive.user.BankUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Transaction {
	
	private @Id @GeneratedValue Long id_transaction;
	
	@JsonIgnoreProperties({"knownUsers", "password"})
	@OneToOne
	private BankUser sender;
	
	@JsonIgnoreProperties({"knownUsers", "password"})
	@OneToOne
	private BankUser receiver;
	
	private String amount;
	
	private Transaction() {
		
	}
	
	public Transaction(BankUser sender, BankUser receiver, String amount) {
		super();
		this.sender = sender;
		this.receiver = receiver;
		this.amount = amount;
	}

	public Long getId_transaction() {
		return id_transaction;
	}

	public void setId_transaction(Long id_transaction) {
		this.id_transaction = id_transaction;
	}

	public BankUser getSender() {
		return sender;
	}

	public void setSender(BankUser sender) {
		this.sender = sender;
	}

	public BankUser getReceiver() {
		return receiver;
	}

	public void setReceiver(BankUser receiver) {
		this.receiver = receiver;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}
}
