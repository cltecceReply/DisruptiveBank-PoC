package com.example.disruptive.bankaccount;

public class AccountResponse {
	
	private Account[] accounts;
	
	public AccountResponse() {
		super();
	}

	public AccountResponse(Account[] accounts) {
		super();
		this.accounts = accounts;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}
	
	public Account getAccount(int index) {
		return this.accounts[index];
	}
	
}
