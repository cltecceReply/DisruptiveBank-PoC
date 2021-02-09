package com.example.disruptive.user;

public class CustomerDetails {
	
	private String first_name;
	private String last_name;
	private String mobile_phone_number;
	
	public CustomerDetails() {
		super();
	}
	
	public CustomerDetails(String first_name, String last_name, String mobile_phone_number) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile_phone_number = mobile_phone_number;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMobile_phone_number() {
		return mobile_phone_number;
	}

	public void setMobile_phone_number(String mobile_phone_number) {
		this.mobile_phone_number = mobile_phone_number;
	}
	
	@Override
    public String toString() {
        return "{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", mobile_phone_number=" + mobile_phone_number + '\'' +
                '}';
    }
}
