package com.hcl.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.prem.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	public List<User> getUserByusername(String name);

}
