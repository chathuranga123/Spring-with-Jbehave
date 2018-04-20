package com.test.dao.login.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import com.test.dao.login.LoginDao;
import com.test.mapping.user.User;

@Repository
@Scope("prototype")
public class LoginDaoImpl implements LoginDao{
	
	public User getUser(String username, String password) throws Exception {
		User user=new User();
		return user;
	}
}
