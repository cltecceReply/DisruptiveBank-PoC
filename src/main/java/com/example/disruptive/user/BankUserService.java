package com.example.disruptive.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.disruptive.caller.RestService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class BankUserService implements UserDetailsService {

	@Autowired
	private BankUserRepository bankUserRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RestService restService;

	public ArrayList<BankUser> getAllUsers() {
		ArrayList<BankUser> bankUsers = new ArrayList<>();
		bankUserRepository.findAll().forEach(bankUsers::add);
		return bankUsers;
	}

	public BankUser getUser(Long id) {
		return bankUserRepository.findById(id).get();
	}
	
	public BankUser getUserByEmail(String email) {
		return bankUserRepository.findByEmail(email);
	}
	
	public BankUser getUserByPhone(String phone) {
		return bankUserRepository.findByPhone(phone);
	}

	public void addUser(BankUser bankUser) {
		
		bankUser.setPassword(passwordEncoder.encode(bankUser.getPassword()));
		if (!bankUserRepository.existsByPhone(bankUser.getPhone()) && !bankUserRepository.existsByEmail(bankUser.getEmail()))
		{
			bankUserRepository.save(bankUser);
		} else {
			return;
		}
		
		Identifiers identifiers1 = new Identifiers("IDENTIFIER_TYPE_EMAIL", bankUser.getEmail());
		Identifiers identifiers2 = new Identifiers("IDENTIFIER_TYPE_PHONE", ""+bankUser.getPhone());
		Identifiers[] identifiers = {identifiers1, identifiers2};
		CustomerDetails customer_details = new CustomerDetails(bankUser.getName(), bankUser.getSurname(),bankUser.getPhone());
		Customer customer = new Customer("CUSTOMER_STATUS_ACTIVE", identifiers, customer_details);
		
		CustomerRequest customerOnVault = new CustomerRequest(customer);
		this.restService.createCustomerOnVault(customerOnVault);
	}

	public void deleteUser(Long id) {
		bankUserRepository.deleteById(id);
	}
	
	public void addKnownUser(Long id, String phone) {
		if (!bankUserRepository.existsByPhone(phone))
			return;
		if (!bankUserRepository.existsById(id))
			return;
		
		BankUser user = bankUserRepository.findById(id).get();
		BankUser userToAdd = bankUserRepository.findByPhone(phone);
		user.addKnownUser(userToAdd);
		bankUserRepository.save(user);
	}
	
	/**
	 * 
	 * @param id dell'utente autenticato che vuole eliminare dalla sua rubrica un contatto 
	 * @param phone numero del contatto che si vuole elimare dalla rubrica dell'utente autenticato.
	 */
	public void deleteKnownUser(Long id, String phone) {
		if (!bankUserRepository.existsByPhone(phone))
			return;
		if (!bankUserRepository.existsById(id))
			return;
	
		BankUser user = bankUserRepository.findById(id).get();
		BankUser userToDelete = bankUserRepository.findByPhone(phone);
		user.deleteKnownUser(userToDelete);
		bankUserRepository.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		final BankUser bankUser = bankUserRepository.findByEmail(email);
		if(bankUser == null) {
			throw new UsernameNotFoundException(email);
		}
		UserDetails user = User.withUsername(bankUser.getEmail()).password(bankUser.getPassword()).authorities("ROLE_USER").build();
		return user;
	}	
}
