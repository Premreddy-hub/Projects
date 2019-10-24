package com.prem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prem.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{

	@Query("SELECT e from User e Where username = ?1 And password= ?2")
	List<User> findByUsernameAndPassword(String username,String password);
	
	List<User> findByUsername(String username);
}
