package com.hcl.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.prem.User;
import com.hcl.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;

	@Override
	public List<User> getUser(String username) {
		return userRepo.getUserByusername(username);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> listuser = (List<User>) userRepo.findAll();
		if(listuser != null) {
			return listuser;
		} else {
			
		return new ArrayList<User>();
	}
	
	}

	@Override
	public String addUser(User user) {
		User temp = userRepo.save(user);
		if(temp != null) {
			return "***CREATED***";
		} else {
		
			return "***NOT POSSIBLE***";
		}
	}

}
