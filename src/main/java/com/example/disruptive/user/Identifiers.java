package com.example.disruptive.user;

public class Identifiers {
	
	private String identifier_type;
	private String identifier;
	
	public Identifiers() {
		super();
	}
	
	public Identifiers(String identifier_type, String identifier) {
		super();
		this.identifier_type = identifier_type;
		this.identifier = identifier;
	}
	public String getIdentifier_type() {
		return identifier_type;
	}
	public void setIdentifier_type(String identifier_type) {
		this.identifier_type = identifier_type;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
}
