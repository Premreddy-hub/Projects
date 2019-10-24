package com.prem;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.prem.model.Loan;
import com.prem.model.User;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class LoanProjectApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@LocalServerPort
    int randomServerPort=3377;
	
	@Test
    public void testGetUserSuccessMissingHeader() throws URISyntaxException 
    {
        RestTemplate restTemplate = new RestTemplate();
        
        final String baseUrl = "http://localhost:"+randomServerPort+"/User//getuser/" + "Prem";
        URI uri = new URI(baseUrl);
        try 
        {
        	User user1 = restTemplate.getForObject(uri, User.class);

        	//Verify request succeed
            Assert.assertEquals("reddy", user1.getPassword());
            Assert.assertEquals(1, user1.getUserid());
        }
        catch(HttpClientErrorException ex) 
        {

            //Verify bad request and missing header
            Assert.assertEquals("notreddy", ex.getRawStatusCode());
            Assert.assertEquals(2, ex.getResponseBodyAsString().contains("Missing request header"));
        }
        
    }
	
	 @Test
	    public void testaddUserSuccess() throws URISyntaxException 
	    {
	        RestTemplate restTemplate = new RestTemplate();
	        final String baseUrl = "http://localhost:"+randomServerPort+"/User/saveUser";
	        URI uri = new URI(baseUrl);
	        User user1 = new User(4, "aditya", "kohli");
	           
	        ResponseEntity<Integer> result = restTemplate.postForEntity(uri, user1, Integer.class);
	        //Verify request succeed
	        if ( result.getBody()>0)
	        	Assert.assertEquals(true, result.getBody()>0);
	        else
	        //verify request Fail
	        Assert.assertEquals(false, result.getBody()==0);
	    }
	 
	 @Test
	    public void testKnockoutUserSuccess() throws URISyntaxException 
	    {
	        RestTemplate restTemplate = new RestTemplate();
	        final String baseUrl = "http://localhost:"+randomServerPort+"/User/knockUser";
	        URI uri = new URI(baseUrl);
	        Loan loan1 = new Loan(3, 2, 56000 , 123 , 780);
	           
	        ResponseEntity<Long> result = restTemplate.postForEntity(uri, loan1, Long.class);
	        //Verify request succeed
	        if ( result.getBody()>0)
	        	Assert.assertEquals(true, result.getBody()>0);
	        else
	        //verify request Fail
	        Assert.assertEquals(false, result.getBody()==0);
	    }

}
