package com.example.disruptive.postings;

import java.util.UUID;

public class PostingInstruction {
	
	private String client_transaction_id = UUID.randomUUID().toString();
	private Transfer transfer;
	
	public PostingInstruction() {
		super();
	}
	
	public PostingInstruction(Transfer transfer) {
		super();
		this.transfer = transfer;
	}
	public String getClient_transaction_id() {
		return client_transaction_id;
	}
	public void setClient_transaction_id(String client_transaction_id) {
		this.client_transaction_id = client_transaction_id;
	}
	public Transfer getTransfer() {
		return transfer;
	}
	public void setTransfer(Transfer transfer) {
		this.transfer = transfer;
	}
	
	
}
