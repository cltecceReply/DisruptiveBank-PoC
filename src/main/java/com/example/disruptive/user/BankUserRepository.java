package com.example.disruptive.user;

import org.springframework.data.repository.CrudRepository;

public interface BankUserRepository extends CrudRepository<BankUser, Long> {
	
	public BankUser findByPhone(String phone);
	public BankUser findByEmail(String email);
	
	public boolean existsByPhone(String phone);
	public boolean existsByEmail(String email);
}
