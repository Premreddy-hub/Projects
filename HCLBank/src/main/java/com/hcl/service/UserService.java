package com.hcl.service;

import java.util.List;

import com.hcl.prem.Account;
import com.hcl.prem.User;

public interface UserService {
	

	public List<User> getUser(String username);
	
	public List<User> getAllUsers();
	
	public String addUser(User user);
}
