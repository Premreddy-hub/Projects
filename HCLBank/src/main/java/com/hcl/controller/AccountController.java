package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.prem.Account;
import com.hcl.service.AccountService;

@RestController
@RequestMapping(value="/account")
public class AccountController {
	
	@Autowired
	AccountService accser;
	
	@GetMapping(value = "/getAllAccounts")
	public List<Account> getAllAccounts() {
		return accser.getAllAccounts();
		
	}
	
	@PostMapping(value="/create")
	public String createAccount(@RequestBody Account account) {
		return accser.createAccount(account);
	}
	
	@DeleteMapping(value="/delete/{accountnum}")
	public String deleteAccount(@PathVariable int accountnum) {
		return accser.deleteAccount(accountnum);
	}
	
	@PostMapping(value="/credit")
	public String creditAmount(@RequestBody Account account){
		return accser.creditAmount(account);
	}

}
