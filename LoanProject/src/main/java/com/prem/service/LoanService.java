package com.prem.service;

import java.util.List;
import java.util.Optional;

import org.bouncycastle.asn1.x509.sigi.PersonalData;

import com.prem.model.Loan;
import com.prem.model.PersonalTable;
import com.prem.model.Product;
import com.prem.model.User;

public interface LoanService{

		public User getUser(String i);
		
		public int addUser(User user);
		
		public String addpersonaldetails(PersonalTable personaldata);
		
		public long Knockout(Loan loan);
		
		public List<Loan> getLoanDetails (int userid);
		
		public long Existing(int propertyid);
		
		public boolean ExistingLoanDone(Loan loan);
		
		public long Productloan(Product product);
		
		public boolean ApplyProductLoan(Product product);
		
		public List<Product> getProductDetails (int userid);
		
		public long ExistingProductLoan(int productid);
	
}
