package com.test.jbehave.steps;

import java.util.List;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.test.dao.home.HomeDao;
import com.test.dao.home.impl.HomeDaoImpl;
import com.test.mapping.useraccount.UserAccount;
import com.test.util.common.Common;
import com.test.util.varlist.CommonVarList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/springjbehave-servlet.xml")
@WebAppConfiguration
public class UserAccountListSteps {
	@Autowired
	ApplicationContext context;
	
	@Mock
	JdbcTemplate jdbcTemplate;
	
	@Mock
	CommonVarList commonVarList;
	
	@Mock
	Common common;
	
	@InjectMocks
	HomeDao homeDao =new HomeDaoImpl();
	
	@BeforeScenario
	public void initMocks(){
		System.out.println("--------------- 1");
		MockitoAnnotations.initMocks(this);
		System.out.println("--------------- 2");
		//this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
		System.out.println("--------------- 3");
	}
	
	@Given("customer userid is $userid")
	@Test
	public void checkUserAccountList() throws Exception{
		List<UserAccount> userAccountList=homeDao.getUserAccountList("1");
	}
}
