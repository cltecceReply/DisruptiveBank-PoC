package com.example.disruptive.transaction;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.disruptive.bankaccount.BankAccount;
import com.example.disruptive.bankaccount.BankAccountService;
import com.example.disruptive.jsonutility.TransactionInfo;
import com.example.disruptive.user.BankUser;
import com.example.disruptive.user.BankUserService;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@Autowired
	private BankUserService bankUserService;
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/users/transactions")
	public void executeTransaction(@RequestBody TransactionInfo transactionInfo) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = authentication.getName();
		transactionService.executeTransaction(userEmail, transactionInfo.getPhone(), transactionInfo.getAmount());
	}
	
	@RequestMapping("/users/transactions")
	public List<Transaction> getTransactions() {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = authentication.getName();
		BankUser bankUser = bankUserService.getUserByEmail(userEmail);
		return transactionService.getTransactionUser(bankUser);
	}
}
