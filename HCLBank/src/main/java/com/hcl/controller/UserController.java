package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.prem.Account;
import com.hcl.prem.User;
import com.hcl.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserService userser;


	@GetMapping(value = "/{username}/get")
	public List<User> getUser(@PathVariable String username) {
		return userser.getUser(username);
	}

	@GetMapping(value="/allusers")
	public List<User> getAllUsers() {
		return userser.getAllUsers();
	}
	
	@PostMapping(value="/add")
	public String createUser(@RequestBody User user) {
		return userser.addUser(user);
	}
}
