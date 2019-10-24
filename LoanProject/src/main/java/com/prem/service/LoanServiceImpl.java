package com.prem.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.prem.model.Loan;
import com.prem.model.PersonalTable;
import com.prem.model.Product;
import com.prem.model.User;
import com.prem.repository.LoanRepository;
import com.prem.repository.PersonalDataRepository;
import com.prem.repository.ProductRepository;
import com.prem.repository.UserRepository;


@Service
public class LoanServiceImpl implements LoanService {

	@Autowired
	UserRepository repo;

	@Autowired
	PersonalDataRepository repopersonal;

	@Autowired
	LoanRepository loanrepo;
	
	@Autowired
	ProductRepository prorepo;

	long globalvar = 0;
	long globalprovar = 0;

	@Override
	public User getUser(String id) {
		List<User> us = repo.findByUsername(id);
		return us.get(0);
	}

	@Override
	public int addUser(User user) {
		User tempuser = repo.save(user);
		List<User> listus = repo.findByUsername(tempuser.getUsername());
		User us1 = listus.get(0);
		if (us1 != null) {
			return us1.getUserid();
		} else {
			return 0;
		}
	}

	@Override
	public String addpersonaldetails(PersonalTable personaldata) {
		Random rand = new Random();
		personaldata.setCreditscore((rand.nextInt(500) + 500));
		if (rand.nextBoolean()) {
			personaldata.setPremium("yes");
		} else {
			personaldata.setPremium("no");
		}
		PersonalTable temppersonal = repopersonal.save(personaldata);
		if (temppersonal != null) {
			return "PersonalDetails saved successfully";
		} else {
			return "Not Saved";
		}
	}

	@Override
	public long Knockout(Loan loan) {
		long longgg = 0;
		double amount = 0;
		PersonalTable detail = new PersonalTable();
		detail = (repopersonal.findById(loan.getUserid())).get();
		long sq_price = 0;
		if (detail.getLegalresident().equals("yes") && detail.getCreditscore() > 600) {
			if (loan.getArea_code() >= 0 && loan.getArea_code() <= 50) {
				sq_price = 2000;
			} else if (loan.getArea_code() >= 51 && loan.getArea_code() <= 150) {
				sq_price = 3000;
			} else if (loan.getArea_code() >= 151 && loan.getArea_code() <= 200) {
				sq_price = 4000;
			}
			amount = loan.getProperty_sq() * sq_price * (((double) detail.getCreditscore()) / 1000);
			if (detail.getPremium().equals("yes")) {
				amount = amount * 1.05;
			}
			longgg = (long) amount;

		} else
			longgg = -404;

		globalvar = longgg;
		return longgg;

	}

	@Override
	public List<Loan> getLoanDetails(int userid) {
		List<Loan> loanlist = (List<Loan>) loanrepo.findAllByUserid(userid);
		return loanlist;
	}

	@Override
	public long Existing(int propertyid) {
		double amount = 0;
		long longgg = 0;
		System.out.println(propertyid);
		Loan loan = loanrepo.findById(propertyid).get();
		System.out.println(loan);
		PersonalTable detail = new PersonalTable();
		detail = repopersonal.findById(loan.getUserid()).get();
		System.out.println(detail);
		long sq_price = 0;
		if (loan.getArea_code() >= 0 && loan.getArea_code() <= 50) {
			sq_price = 2000;
		} else if (loan.getArea_code() >= 51 && loan.getArea_code() <= 150) {
			sq_price = 3000;
		} else if (loan.getArea_code() >= 151 && loan.getArea_code() <= 200) {
			sq_price = 4000;
		}
		amount = (loan.getProperty_sq() * sq_price * (((double) detail.getCreditscore()) / 1000));
		if (detail.getPremium().equals("yes")) {
			amount = amount * 1.05;
		}
		amount = amount - loan.getAmount();
		longgg = (long) amount;
		globalvar = longgg;
		return longgg;
	}

	@Override
	public boolean ExistingLoanDone(Loan loan) {
		boolean bool = false;
		if (loan.getAmount() <= globalvar) {
			Loan loanexist = null;
			try {
				loanexist = loanrepo.findById(loan.getPropertyid()).get();
				int i = loanexist.getAmount() + loan.getAmount();
				loanexist.setAmount(i);
				loanrepo.save(loanexist);
				bool = true;

			} catch (NoSuchElementException e) {
				loanrepo.save(loan);
				bool = true;
			}
		}
		return bool;
	}

	@Override
	public long Productloan(Product product) {
		double amount = 0;
		long productloan;
		PersonalTable details = repopersonal.findById(product.getUserid()).get();
		if (details.getCreditscore() > 600 && details.getLegalresident().equals("yes") ){
			if (product.getProducttype().equals("gold")) {
				amount = product.getWeight() * 4000;
			}
			if (product.getProducttype().equals("platinum")) {
				amount = product.getWeight() * 5000;
			}
			if (product.getProducttype().equals("diamond")) {
				amount = product.getWeight() * 7000;
			}
		} else {
			amount = -404;
		}
		productloan = (long) amount;
		globalprovar = productloan;
	
		return productloan;
	}

	@Override
	public boolean ApplyProductLoan(Product product) {
		boolean bool = false;
		System.out.println("\n\n\n last "+product+"");
		System.out.println("laksh amoiun rtjuhjhnisfuh " + globalprovar);
		if(product.getAmount()<globalprovar) {
			Product Productexist = null;
			try {
				Productexist = prorepo.findById(product.getProductid()).get();
				int i = Productexist.getAmount() + product.getAmount();
				Productexist.setAmount(i);
				prorepo.save(Productexist);
				bool = true;

			} catch (NoSuchElementException e) {
				prorepo.save(product);
				bool = true;
			}
		}
		return bool;
	}

	@Override
	public List<Product> getProductDetails(int userid) {
		List<Product> listpro = prorepo.findAllByUserid(userid);
		return listpro;
	}

	@Override
	public long ExistingProductLoan(int productid) {
		double amount = 0;
		long productloan;
		Product product1 = prorepo.findById(productid).get();
		if (product1.getProducttype().equals("gold")) {
			amount = product1.getWeight() * 4000;
		}
		else if (product1.getProducttype().equals("platinum")) {
			amount = product1.getWeight() * 5000;
		}
		else if(product1.getProducttype().equals("diamond")) {
			amount = product1.getWeight() * 7000;
		}
		amount = amount - product1.getAmount() ;
		productloan = (long) amount;
		globalprovar = productloan;
		return productloan;
	}
}