package com.example.disruptive.bankaccount;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.example.disruptive.user.BankUser;

@Entity
public class BankAccount {
	
	private @Id @GeneratedValue Long code;
	
	//Balance serve per inizializzare l'Account che si crea su Vault.
	private String balance;
	//Questi diventano parametri dello smart contract
	private String dailyMax;
	private String maxForTransaction;
	//Logica di adesione sempre da spostare su Vault.
	private String instantPaymentAdherence = "false";
	
	@OneToOne
	@JoinColumn(name="id", nullable=false)
	private BankUser bankUser;
	
	public BankAccount() {
	}
	
	public BankAccount(String balance, String dailyMax, String maxForTransaction, String instantPaymentAdherence) {
		super();
		this.balance = balance;
		this.dailyMax = dailyMax;
		this.maxForTransaction = maxForTransaction;
		this.instantPaymentAdherence = instantPaymentAdherence;
	}
	
	public BankUser getBankUser() {
		return bankUser;
	}

	public void setBankUser(BankUser bankUser) {
		this.bankUser = bankUser;
	}

	public Long getCode() {
		return code;
	}
	
	public void setCode(Long code) {
		this.code = code;
	}
	
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getDailyMax() {
		return dailyMax;
	}
	public void setDailyMax(String dailyMax) {
		this.dailyMax = dailyMax;
	}
	public String getMaxForTransaction() {
		return maxForTransaction;
	}
	public void setMaxForTransaction(String maxForTransaction) {
		this.maxForTransaction = maxForTransaction;
	}
	
	public String isInstantPaymentAdherence() {
		return instantPaymentAdherence;
	}
	
	public void setInstantPaymentAdherence(String instantPaymentAdherence) {
		this.instantPaymentAdherence = instantPaymentAdherence;
	}
	
	public void updateBankAccount(BankAccount bankAccount)
	{
		this.balance = bankAccount.balance;
		this.dailyMax = bankAccount.dailyMax;
		this.maxForTransaction = bankAccount.maxForTransaction;
		this.instantPaymentAdherence = bankAccount.instantPaymentAdherence;
	}
}
