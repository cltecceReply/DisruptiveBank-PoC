package com.example.disruptive.auth;

//Descrive una richiesta di autenticazione, si suppone che l'utente esegua il login con email e password.
public class AuthenticationRequest {
	
	private String email;
	private String password;
	
	public AuthenticationRequest() {
		
	}
	
	public AuthenticationRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
