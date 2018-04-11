package com.test.service.home.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.bean.session.SessionBean;
import com.test.dao.home.HomeDao;
import com.test.mapping.useraccount.UserAccount;
import com.test.service.home.HomeService;

@Service
public class HomeServiceImpl implements HomeService{
	@Autowired
	SessionBean sessionBean;
	
	@Autowired
	HomeDao homeDao;
	
	@Override
	public List<UserAccount> getUserAccounts() throws Exception {
		List<UserAccount> userAccountList;
		try{
			String userId=sessionBean.getUserId();
			userAccountList=homeDao.getUserAccountList(userId);
		}catch(Exception e){
			throw e;
		}
		return userAccountList;
	}
}
