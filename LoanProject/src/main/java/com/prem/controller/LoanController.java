package com.prem.controller;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.bouncycastle.asn1.x509.sigi.PersonalData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prem.model.Loan;
import com.prem.model.PersonalTable;
import com.prem.model.Product;
import com.prem.model.User;

import com.prem.service.LoanService;

@RestController
@RequestMapping("/User")
public class LoanController {
	
	private static final Logger logger = Logger.getLogger(LoanController.class);

	@Autowired
	LoanService loanservice;
	
	@RequestMapping("/getuser/{name}")
	public User getUser(@PathVariable("name") String name) {
		logger.info("Entering into the getUser method");
		System.out.println("\n\n\n"+name+"\n\n\n\n");
		User us=loanservice.getUser(name);
		return us;
	}
	
	@RequestMapping(value = "/saveUser" , method = RequestMethod.POST)
	public int addUser(@RequestBody User user){
		logger.info("Entering into the addUser method");
			return loanservice.addUser(user);
	}
	
	@RequestMapping(value = "/savePersonalData" , method = RequestMethod.POST)
	public String addPersonalData(@RequestBody PersonalTable personaldata){
		logger.info("Entering into the addPersonalData method");
			return loanservice.addpersonaldetails(personaldata);
	}
	
	@RequestMapping(value = "/knockUser" , method = RequestMethod.POST)
	public long KnockoutUser(@RequestBody Loan loan) { 
		logger.info("Entering into the knockoutUser method");
		return loanservice.Knockout(loan);
	}
	
	@RequestMapping("/getLoanDetails/{id}")
	public List<Loan> getLoanList(@PathVariable("id") int id) {
		logger.info("Entering into the getLoanList method");
		List<Loan> us=loanservice.getLoanDetails(id);
		return us;
	}
	
	@RequestMapping(value = "/ExistingUser/{id}" , method = RequestMethod.GET)
	public long ExistingUser(@PathVariable("id") int id) {
		logger.info("Entering into the existingUser method");
		System.out.println(id);
		return loanservice.Existing(id);
	}
	
	@RequestMapping(value = "/ExistingLoanDone" , method = RequestMethod.POST)
	public boolean ExistingLoanDone(@RequestBody Loan loan) {
		logger.info("Entering into the ExistingLoanDone method");
		System.out.println("\n\n\n"+loan);
		return loanservice.ExistingLoanDone(loan);
	}

	@RequestMapping(value = "/productLoan" , method = RequestMethod.POST)
	public long Productloan(@RequestBody Product product) {
		logger.info("Entering into the ProductLoan method");
		System.out.println("\n\n\n\n\n"+ "RAGHU "+product);
		return loanservice.Productloan(product);
	}
	
	@RequestMapping(value = "/ApplyProductLoan" , method = RequestMethod.POST)
	public boolean ApplyProductLoan(@RequestBody Product product) {
		logger.info("Entering into the ApplyProduction method");
		System.out.println("\n\n\n\n\n" + "lAKSH " +product);
		return loanservice.ApplyProductLoan(product);
	}
	
	@RequestMapping("/getProductDetails/{id}")
	public List<Product> getProductDetails(@PathVariable("id") int id) {
		logger.info("Entering into the getProductDetails method");
		List<Product> us=loanservice.getProductDetails(id);
		return us;
	}
	
	@RequestMapping(value = "/ExistingProductLoan/{id}" , method = RequestMethod.GET)
	public long ExistingProductLoan(@PathVariable("id") int id) {
		logger.info("Entering into the ExistingProduction method");
		System.out.println(id);
		return loanservice.ExistingProductLoan(id);
	}
	
}
