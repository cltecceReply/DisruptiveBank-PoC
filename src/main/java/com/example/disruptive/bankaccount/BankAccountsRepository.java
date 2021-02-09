package com.example.disruptive.bankaccount;

import org.springframework.data.repository.CrudRepository;

import com.example.disruptive.user.BankUser;

public interface BankAccountsRepository extends CrudRepository<BankAccount, Long> {
	
	public BankAccount findByBankUser(BankUser bankUser);
	
	public boolean existsByBankUser(BankUser bankUser);
	
}
