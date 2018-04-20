package com.test.jbehave.steps;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

import com.test.dao.home.HomeDao;
import com.test.mapping.useraccount.UserAccount;

@Component
public class UserAccountListSteps {

	@Autowired
	private HomeDao homeDao;
	
	private List<UserAccount> userAccountList;
	
	@Given("customer userid is $userid")
	public void checkUserAccountList(String userid) throws Exception {
		userAccountList = homeDao.getUserAccountList(userid);
	}
	
	@Then("customer account list size should be $account_list_size")
	public void thenUserAccountListSize(int account_list_size) {
		if (userAccountList.size() != account_list_size){
            throw new RuntimeException("result is " + userAccountList.size() + ", but should be " + account_list_size);
        }
	}
}
