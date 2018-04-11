package com.test.service.login.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.login.LoginDao;
import com.test.mapping.user.User;
import com.test.service.login.LoginService;
import com.test.util.common.Common;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	Common common;
	
	@Autowired
	LoginDao loginDao;
	
	public boolean checkValidUser(String username, String password) throws Exception {
		boolean isValidUser;
		try{
			if(common.checkNullAndEmpty(username) && common.checkNullAndEmpty(password)){
				User user = loginDao.getUser(username, password);
				isValidUser = user.isValidUser();
			}else{
				isValidUser=false;
			}
		}catch(Exception e){
			throw e;
		}
		return isValidUser;
	}
}
