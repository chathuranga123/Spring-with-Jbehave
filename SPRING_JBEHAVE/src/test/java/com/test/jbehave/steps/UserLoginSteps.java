package com.test.jbehave.steps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;

import com.test.service.login.LoginService;


@Component
public class UserLoginSteps {
	
	@Autowired
	LoginService loginService;
	
	private boolean isValidUser;
	
	@Given("$username username and $password password")
	public void checkUser(String username, String password) throws Exception{
		isValidUser=loginService.checkValidUser(username, password);
	}
	
	@Then("customer status should be $status")
	public void thenUserStatusShouldBe(boolean status) {
		if (!isValidUser){
            throw new RuntimeException("result is " + status + ", but should be " + isValidUser);
        }
	}
}
