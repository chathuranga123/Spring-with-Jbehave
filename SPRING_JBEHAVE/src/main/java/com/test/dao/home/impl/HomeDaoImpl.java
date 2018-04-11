package com.test.dao.home.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.test.dao.home.HomeDao;
import com.test.mapping.useraccount.UserAccount;
import com.test.util.common.Common;
import com.test.util.varlist.CommonVarList;

@Repository
@Scope("prototype")
public class HomeDaoImpl implements HomeDao{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	CommonVarList commonVarList;
	
	@Autowired
	Common common;
	
	private final Log logger = LogFactory.getLog(getClass());
	
	private final String sqlUserAccountList ="SELECT USERID,ACCOUNTNO,ACCOUNTTYPE,BANK,STATUS,ACC_HOLDER_NAME,BRANCH FROM USERACCOUNT WHERE USERID=? AND STATUS=?";
	
	@Override
	public List<UserAccount> getUserAccountList(String userId) throws Exception {
		List<UserAccount> userAccountList=new ArrayList<UserAccount>();
		try{
			
			List<Map<String, Object>> resultSet=jdbcTemplate.queryForList(sqlUserAccountList,new Object[] {userId,commonVarList.STATUS_DEFAULT_ACTIVE});
			
			if(!resultSet.isEmpty()){
				for(Map<String,Object> record : resultSet){
					UserAccount userAccount=new UserAccount();
					
					userAccount.setUserId(common.replaceNullAndEmpty(record.get("USERID")));
					userAccount.setAccountNumber(common.replaceNullAndEmpty(record.get("ACCOUNTNO")));
					userAccount.setAccountType(common.replaceNullAndEmpty(record.get("ACCOUNTTYPE")));
					userAccount.setBank(common.replaceNullAndEmpty(record.get("BANK")));
					userAccount.setStatus(common.replaceNullAndEmpty(record.get("STATUS")));
					userAccount.setAccountHolderName(common.replaceNullAndEmpty(record.get("ACC_HOLDER_NAME")));
					userAccount.setBranch(common.replaceNullAndEmpty(record.get("BRANCH")));
					
					userAccountList.add(userAccount);
					
					System.out.println(userAccount.toString());
				}
			}
		}catch(Exception e){
			logger.error("Exception  :  ", e);
			throw e;
		}
		return userAccountList;
	}
}
