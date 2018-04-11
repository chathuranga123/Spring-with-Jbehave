package com.test.dao.login;

import com.test.mapping.user.User;

public interface LoginDao {
	public User getUser(String username , String password)throws Exception;
}
