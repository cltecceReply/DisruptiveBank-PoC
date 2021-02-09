package com.example.disruptive.bankaccount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.disruptive.caller.RestService;
import com.example.disruptive.postings.CreditorAccountTarget;
import com.example.disruptive.postings.DebtorAccountTarget;
import com.example.disruptive.postings.PostingInstruction;
import com.example.disruptive.postings.PostingInstructionBatch;
import com.example.disruptive.postings.PostingRequest;
import com.example.disruptive.postings.Transfer;
import com.example.disruptive.user.BankUser;

@Service
public class BankAccountService {
	
	@Autowired
	private BankAccountsRepository bankAccountRepository;
	
	@Autowired
	private RestService restService;
	
	public BankAccount getBankAccount(Long code) {
		return bankAccountRepository.findById(code).get();
	}
	
	public void addBankAccount(BankAccount bankAccount) {
		bankAccountRepository.save(bankAccount);
	}
	
	public void deleteBankAccount(Long code) {
		bankAccountRepository.deleteById(code);
	}
	
	public BankAccount getBankAccountFromUser(BankUser user) {
		return bankAccountRepository.findByBankUser(user);
	}
	
	public boolean checkIfUserAlredyHasAnAccount(BankUser user) {
		return bankAccountRepository.existsByBankUser(user);
	}
	
	public void addAccountOnVault(BankAccount bankAccount,String email) {
		
		String customer_id = this.restService.retriveCustomerOnVault(email).getId();
		String[] permitted_denominations = {"GBP"};
		String[] stakeholder_ids = {customer_id};
		Map<String, String> instance_param_vals = new HashMap<>();
		instance_param_vals.put("arranged_overdraft_limit", bankAccount.getDailyMax());
		instance_param_vals.put("unarranged_overdraft_limit", bankAccount.getMaxForTransaction());
		instance_param_vals.put("interest_application_day", "20");
		Account account = new Account("current_account", permitted_denominations, "ACCOUNT_STATUS_OPEN", stakeholder_ids, instance_param_vals);
		AccountRequest accountRequest = new AccountRequest(account);
		
		this.restService.createAccountOnVault(accountRequest);
		String account_id = this.restService.retrieveAccountOnVault(customer_id).getId();
		DebtorAccountTarget debtor_target_account = new DebtorAccountTarget("1");
		CreditorAccountTarget creditor_target_account = new CreditorAccountTarget(account_id);
		Transfer transfer = new Transfer(bankAccount.getBalance(), "GBP", debtor_target_account, creditor_target_account);
		PostingInstruction[] posting_instructions = {new PostingInstruction(transfer)};
		PostingInstructionBatch posting_instruction_batch = new PostingInstructionBatch("ClientOfLory", posting_instructions);
		PostingRequest postingRequest = new PostingRequest(posting_instruction_batch);
		this.restService.foundAccountWithInitialBalance(postingRequest);
	}
}
