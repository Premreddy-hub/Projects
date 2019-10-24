package com.hcl.service;

import java.util.List;

import com.hcl.prem.Account;

public interface AccountService {
	
	public List<Account> getAllAccounts();
	
	public String createAccount(Account acc);
	
	public String deleteAccount(int accountnum);
	
	public String creditAmount(Account acc);

	
}
