package com.test.jbehave.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.jbehave.core.annotations.Given;
import com.test.service.login.LoginService;


@Component
public class UserLoginSteps {
	
	@Autowired
	LoginService loginService;
	
	@Given("$username username and $password password")
	public void checkUser(String username, String password) throws Exception{
		boolean flag=loginService.checkValidUser(username, password);
		System.out.println("flag ->"+flag);
	}
}
