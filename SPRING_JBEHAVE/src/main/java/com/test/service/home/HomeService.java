package com.test.service.home;

import java.util.List;
import com.test.mapping.useraccount.UserAccount;

public interface HomeService {
	public List<UserAccount> getUserAccounts() throws Exception;
}
