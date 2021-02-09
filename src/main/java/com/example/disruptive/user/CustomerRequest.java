package com.example.disruptive.user;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class CustomerRequest implements Serializable {
	
	private String request_id = UUID.randomUUID().toString();
	private Customer customer;
	
	public CustomerRequest() {
		super();
	}
	
	public CustomerRequest(Customer customer) {
		super();
		this.customer = customer;
	}

	public String getRequest_id() {
		return request_id;
	}
	public void setRequest_id(String request_id) {
		this.request_id = request_id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
}
