package com.example.disruptive.transaction;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.disruptive.user.BankUser;

public interface TransactionRepository extends CrudRepository<Transaction, Long> {
	
	public List<Transaction> findBySender(BankUser sender);
	public List<Transaction> findByReceiver(BankUser receiver);

}
