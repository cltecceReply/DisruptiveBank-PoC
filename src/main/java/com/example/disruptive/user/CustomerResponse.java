package com.example.disruptive.user;

public class CustomerResponse {
	
	private Customer[] customers;
	
	public CustomerResponse() {
		super();
	}

	public CustomerResponse(Customer[] customers) {
		super();
		this.customers = customers;
	}

	public Customer[] getCustomers() {
		return customers;
	}

	public void setCustomers(Customer[] customers) {
		this.customers = customers;
	}
	
	public Customer getSingleCustomer(int index) {
		return this.customers[index];
	}

}
