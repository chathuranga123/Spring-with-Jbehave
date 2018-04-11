package com.test.util.common;

import org.springframework.stereotype.Component;

@Component
public class Common {
	public boolean checkNullAndEmpty(String value){
		if(value !=null && !value.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
}
