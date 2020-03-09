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
public class LoginController {
	@Autowired
	public UserDAO userDao;
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView userLogin(@RequestParam("userName") String userName,@RequestParam("password") String password) {
		ModelAndView mv=new ModelAndView();
		User user=new User();
		user.setUserName(userName);
		user.setPassword(password);
		String name=userDao.loginUser(user);
		if(name!=null) {
			mv.addObject("msg","Welcome "+name+" you have successfully logged in!!!!");
			mv.setViewName("welcome");
		}
		else {
			mv.addObject("msg","Invalid username or password");
			mv.setViewName("login");
		}
		return mv;
		
	}

}
