package com.test.dao.login.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import com.test.dao.login.LoginDao;
import com.test.mapping.user.User;
import com.test.util.varlist.CommonVarList;

@Repository
@Scope("prototype")
public class LoginDaoImpl implements LoginDao{
	/*@Autowired
	SessionBean sessionBean;*/
	
	/*@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	CommonVarList commonVarList;*/
	
	
	public User getUser(String username, String password) throws Exception {
		User user=new User();
		try{
	
		}catch(Exception e){
			
		}
		return user;
	}
}
