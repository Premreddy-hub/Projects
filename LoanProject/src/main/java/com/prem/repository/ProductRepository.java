package com.prem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.prem.model.Loan;
import com.prem.model.PersonalTable;
import com.prem.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	
	@Query("SELECT e from Product e Where userid = ?1")
	List<Product> findAllByUserid(int userid);

}
