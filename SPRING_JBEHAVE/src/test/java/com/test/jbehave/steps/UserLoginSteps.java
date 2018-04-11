package com.test.jbehave.steps;

import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import com.test.dao.login.LoginDao;
import com.test.mapping.user.User;
import com.test.service.login.LoginService;
import com.test.service.login.impl.LoginServiceImpl;
import com.test.util.common.Common;

public class UserLoginSteps {
	@Mock
	Common common;
	
	@Mock
    LoginDao loginDao;
	
	@InjectMocks
	LoginService loginService =new LoginServiceImpl();
	
	@BeforeScenario
	public void initMocks() {
	    MockitoAnnotations.initMocks(this);
	}
	
	@Given("$username username and $password password")
	@Test
	public void checkUser(String username, String password) throws Exception{

		when(common.checkNullAndEmpty("admin")).thenReturn(true);
		when(common.checkNullAndEmpty("password")).thenReturn(true);
		when(loginDao.getUser("admin","password")).thenReturn(new User());
		
		assertEquals(true,loginService.checkValidUser(username, password));
		verify(loginDao).getUser(username, password);
	}
}
