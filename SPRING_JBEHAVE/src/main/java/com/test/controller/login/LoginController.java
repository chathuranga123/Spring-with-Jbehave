package com.test.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.test.bean.login.LoginInputBean;
import com.test.bean.session.SessionBean;
import com.test.service.home.HomeService;
import com.test.service.login.LoginService;

@Controller
@Scope("request")
public class LoginController {
	private final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	SessionBean sessionBean;
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	HomeService homeService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView getLogin(HttpServletRequest request,HttpServletResponse response){
		ModelAndView modelandview =new ModelAndView("login");
		modelandview.addObject("loginInputBean",new LoginInputBean());
		return modelandview;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView postLogin(HttpServletRequest request,HttpServletResponse response,@ModelAttribute("loginBean")LoginInputBean loginInputBean){
		ModelAndView modelandview = new ModelAndView("login");
		
		try{
			String userName = loginInputBean.getUserName();
			String password = loginInputBean.getPassword();
			
			if(loginService.checkValidUser(userName, password)){
				sessionBean.setUserId("1");
				homeService.getUserAccounts();
				modelandview = new ModelAndView("home");
			}
		}catch(Exception e){
			logger.info("Exception :"+e);
		}
		return modelandview;
	}
}
