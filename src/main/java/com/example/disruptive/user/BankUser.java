package com.example.disruptive.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.example.disruptive.bankaccount.BankAccount;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class BankUser {
	
	private @Id @GeneratedValue Long id;

	private String phone;
	private String name;
	private String surname;
	private String email;
	private String password;
	//Questo valore serve per tenere traccia del Customer su Vault.
	private String customer_id;

	@JsonIgnore
	@ManyToMany
	private List<BankUser> knownUsers = new ArrayList<>();

	public BankUser() {
	}

	public BankUser(String phone, String name, String surname, String email, String password) {
		super();
		this.phone = phone;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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

	public void addKnownUser(BankUser user) {
		this.knownUsers.add(user);
	}

	public void deleteKnownUser(BankUser user) {
		this.knownUsers.remove(user);
	}

	public List<BankUser> getKnownUsers() {
		List<BankUser> nopass = this.knownUsers;
		nopass.forEach((n) -> n.password = null);
		return nopass;
	}

	public boolean isUserKnown(String phone) {

		for (BankUser user : this.knownUsers) {
			if (user.getPhone() == phone)
				return true;
		}
		return false;
	}

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
}
