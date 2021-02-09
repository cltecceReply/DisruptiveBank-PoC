package com.example.disruptive.bankaccount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.disruptive.caller.RestService;
import com.example.disruptive.user.BankUser;
import com.example.disruptive.user.BankUserRepository;
import com.example.disruptive.user.BankUserService;

@RestController
public class BankAccountController {
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@Autowired
	private BankUserService bankUserService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/users/bankaccounts")
	public void addBankAccount(@RequestBody BankAccount bankAccount) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = authentication.getName();
		
		bankAccountService.addAccountOnVault(bankAccount, userEmail);
	}
}