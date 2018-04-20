package com.test.jbehave.steps;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.jbehave.core.annotations.Given;
import com.test.dao.home.HomeDao;
import com.test.mapping.useraccount.UserAccount;

@Component
public class UserAccountListSteps {

	@Autowired
	private HomeDao homeDao;

	@Given("customer userid is $userid")
	public void checkUserAccountList(String userid) throws Exception {
		List<UserAccount> userAccountList = homeDao.getUserAccountList(userid);
		System.out.println("userAccountList  :" + userAccountList);
	}
}
