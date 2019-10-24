package com.prem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prem.model.Loan;
import com.prem.model.User;

@Repository
public interface LoanRepository extends CrudRepository<Loan, Integer>{

	@Query("SELECT e from Loan e Where userid = ?1")
	List<Loan> findAllByUserid(int userid);
}
