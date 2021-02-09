package com.example.disruptive.auth;

//Alla richiesta di Auth rispondiamo con un token JWT (per identificare l'utente il token contiene
//come claim sub la mail dell'utente che si suppone sia univoca).

public class AuthenticationResponse {
	
	private final String jwt;
	
	public AuthenticationResponse(String jwt) {
		this.jwt = jwt;
	}
	
	public String getJwt() {
		return jwt;
	}
}
