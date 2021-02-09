package com.example.disruptive.transaction;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.disruptive.bankaccount.Account;
import com.example.disruptive.bankaccount.BankAccount;
import com.example.disruptive.bankaccount.BankAccountService;
import com.example.disruptive.caller.RestService;
import com.example.disruptive.postings.CreditorAccountTarget;
import com.example.disruptive.postings.DebtorAccountTarget;
import com.example.disruptive.postings.PostingInstruction;
import com.example.disruptive.postings.PostingInstructionBatch;
import com.example.disruptive.postings.PostingRequest;
import com.example.disruptive.postings.Transfer;
import com.example.disruptive.user.BankUser;
import com.example.disruptive.user.BankUserService;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private BankUserService bankUserService;
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@Autowired
	private RestService restService;
	
	public void executeTransaction(String email_sender, String phone_receiver, String amount) {
		
		String customer_id_sender = restService.retriveCustomerOnVault(email_sender).getId();
		Account account_sender = restService.retrieveAccountOnVault(customer_id_sender);
		
		String customer_id_receiver = restService.retriveCustomerOnVaultByPhone(phone_receiver).getId();
		Account account_receiver = restService.retrieveAccountOnVault(customer_id_receiver);
		
		DebtorAccountTarget debtor_target_account = new DebtorAccountTarget(account_sender.getId());
		CreditorAccountTarget creditor_target_account = new CreditorAccountTarget(account_receiver.getId());
		Transfer transfer = new Transfer(amount, "GBP", debtor_target_account, creditor_target_account);
		PostingInstruction[] posting_instructions = {new PostingInstruction(transfer)};
		PostingInstructionBatch posting_instruction_batch = new PostingInstructionBatch("ClientOfLory", posting_instructions);
		PostingRequest postingRequest = new PostingRequest(posting_instruction_batch);
		restService.transferMoneyBetweenCustomersAccounts(postingRequest);
	}
	
	
	public List<Transaction> getTransactionUser(BankUser user) {
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.addAll(transactionRepository.findBySender(user));
		transactions.addAll(transactionRepository.findByReceiver(user));
		return transactions;
	}
	
}
