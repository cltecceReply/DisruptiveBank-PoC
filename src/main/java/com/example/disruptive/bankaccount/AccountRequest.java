package com.example.disruptive.bankaccount;

import java.io.Serializable;
import java.util.UUID;

public class AccountRequest implements Serializable{
	
	private String request_id = UUID.randomUUID().toString();
	private Account account;
	
	public AccountRequest() {
		super();
	}
	
	public AccountRequest(Account account) {
		super();
		this.account = account;
	}

	public String getRequest_id() {
		return request_id;
	}

	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}
