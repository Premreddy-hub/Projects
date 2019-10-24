package com.hcl.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.prem.Account;
import com.hcl.repository.AccountRepository;

@Service

public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository accrep;

	@Override
	public List<Account> getAllAccounts() {
		List<Account> listacc = (List<Account>) accrep.findAll();
		if(listacc != null) {
			return listacc;
		} else {
			return new ArrayList<Account>();
		}
	}

	@Override
	public String createAccount(Account acc) {
		Account create = accrep.save(acc);
		if(create != null) {
			return "***CREATED***";
		} else {
			
		return "***NOT POSSIBLE***";
	}
	}

	@Override
	public String deleteAccount(int accountnum) {

      accrep.deleteById(accountnum);
      return "***REMOVED***";
	}

	@Override
	public String creditAmount(Account acc) {
	 acc.setAmount(accrep.findById(acc.getAccountnum()).get().getAmount()+acc.getAmount());
	 accrep.save(acc);
	  return "***CREDITED***";
	  
	  
	}

	
}
