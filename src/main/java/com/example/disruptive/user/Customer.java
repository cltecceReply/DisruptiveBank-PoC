package com.example.disruptive.user;

import java.util.List;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Customer {
	
	private @Id @GeneratedValue String id;
	//private String id;
	private String status;
	private Identifiers[] identifiers;
	private CustomerDetails customer_details;
	
	public Customer() {
		super();
	}
	
	public Customer( String status, Identifiers[] identifiers, CustomerDetails customer_details) {
		super();
		this.status = status;
		this.identifiers = identifiers;
		this.customer_details = customer_details;
	}
	
	public String getId() {
		return this.id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Identifiers[] getIdentifiers() {
		return identifiers;
	}
	public void setIdentifiers(Identifiers[] identifiers) {
		this.identifiers = identifiers;
	}
	public CustomerDetails getCustomer_details() {
		return customer_details;
	}
	public void setCustomer_details(CustomerDetails customer_details) {
		this.customer_details = customer_details;
	}
}
