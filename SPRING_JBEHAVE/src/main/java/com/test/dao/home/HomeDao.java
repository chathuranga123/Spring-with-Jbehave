package com.test.dao.home;

import java.util.List;
import com.test.mapping.useraccount.UserAccount;

public interface HomeDao {
	public List<UserAccount> getUserAccountList(String customerCIF)throws Exception; 
}
