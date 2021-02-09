package com.example.disruptive.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.disruptive.caller.RestService;
import com.example.disruptive.jsonutility.Phone;

@RestController
public class BankUserController {
	
	@Autowired
	private BankUserService bankUserService;
	
	//Lo sto utilizzando per vedere se dal token JWT mi ritorna l'utente e le informazioni corrette.
	@RequestMapping("/users")
	public BankUser getUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = authentication.getName();
		return bankUserService.getUserByEmail(userEmail);
	}
	
	/**
	 * Questa chiamata non viene controllata da Spring Security, serve per la registrazione
	 * dell'utente.
	 */
	@RequestMapping(method = RequestMethod.POST, value="/signin")
	public void addUser(@RequestBody BankUser user) {
		bankUserService.addUser(user);
	}
	
	/**
	 * Aggiunge un nuovo utente alla lista knownUsers di BankUser.
	 * @param phone, telefono dell'utente che si vuole aggiungere.
	 */
	@RequestMapping(method = RequestMethod.POST, value="/users/contacts")
	public void addKnownUser(@RequestBody Phone phone) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = authentication.getName();
		
		BankUser bankUser = bankUserService.getUserByEmail(userEmail);
		bankUserService.addKnownUser(bankUser.getId(), phone.getPhone());
	}
	
	/**
	 * Ritorna la lista degli utenti conosciuti.
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, value="/users/contacts")
	public List<BankUser> returnKnownUsers() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = authentication.getName();
		
		BankUser bankUser = bankUserService.getUserByEmail(userEmail);
		
		return bankUser.getKnownUsers();
		
	}
	
	/**
	 * Rimuove un utente dalla lista knownUser di BankUser.
	 * @param phone
	 */
	@RequestMapping(method = RequestMethod.DELETE, value="/users/contacts")
	public void deleteKnownUsers(@RequestBody Phone phone) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = authentication.getName();
		
		BankUser bankUser = bankUserService.getUserByEmail(userEmail);
		bankUserService.deleteKnownUser(bankUser.getId(), phone.getPhone());
	}
	
	/**
	 * Rimuove un utente.
	 */
	@RequestMapping(method = RequestMethod.DELETE, value="/users")
	public void deleteUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = authentication.getName();
		BankUser bankUser = bankUserService.getUserByEmail(userEmail);
		bankUserService.deleteUser(bankUser.getId());
	}
}
