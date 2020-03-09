package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.UserDAO;
import com.user.User;
@Controller
public class RegisterController {
	@Autowired
	private UserDAO userDao;
	@RequestMapping(value="/register", method= RequestMethod.POST)
	public ModelAndView userRegistration(@RequestParam("userName")String userName,@RequestParam("password")String password) {
		ModelAndView mv=new ModelAndView();
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		int counter=userDao.registerUser(user);
		if(counter>0) {
			mv.addObject("msg","User Registered Successfully!!!");
			mv.setViewName("login");
		}
		else {
			mv.addObject("msg","Error--check the console log!!!");
			mv.setViewName("registration");
		}
		
		return mv;
	}
}
