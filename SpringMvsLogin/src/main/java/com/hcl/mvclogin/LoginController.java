package com.hcl.mvclogin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
 @RequestMapping("/login")
	public ModelAndView login(HttpServletRequest req,HttpServletResponse res) {
		String user=req.getParameter("userName");
		String pwd=req.getParameter("password");
		if(user.equals("Prem") && (pwd.equals("reddy"))) {
			return new ModelAndView("success","yoyo","Correct Credentials");
			
		} else {
			return new ModelAndView("error","yoyo","Invalid Credentials");
		}
	}
}
