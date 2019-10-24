package com.hcl.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hcl.prem.Account;
import com.hcl.prem.User;

public interface AccountRepository extends CrudRepository<Account, Integer> {
	
	public List<Account> getAccountByaccountnum(int accountnum);
}
