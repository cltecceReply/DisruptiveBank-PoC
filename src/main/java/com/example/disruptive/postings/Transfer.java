package com.example.disruptive.postings;

public class Transfer {
	
	private String amount;
	private String denomination;
	private DebtorAccountTarget debtor_target_account;
	private CreditorAccountTarget creditor_target_account;
	
	public Transfer() {
		super();
	}
	
	public Transfer(String amount, String denomination, DebtorAccountTarget debtor_target_account,
			CreditorAccountTarget creditor_target_account) {
		super();
		this.amount = amount;
		this.denomination = denomination;
		this.debtor_target_account = debtor_target_account;
		this.creditor_target_account = creditor_target_account;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDenomination() {
		return denomination;
	}
	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
	public DebtorAccountTarget getDebtor_target_account() {
		return debtor_target_account;
	}
	public void setDebtor_target_account(DebtorAccountTarget debtor_target_account) {
		this.debtor_target_account = debtor_target_account;
	}
	public CreditorAccountTarget getCreditor_target_account() {
		return creditor_target_account;
	}
	public void setCreditor_target_account(CreditorAccountTarget creditor_target_account) {
		this.creditor_target_account = creditor_target_account;
	}
}
