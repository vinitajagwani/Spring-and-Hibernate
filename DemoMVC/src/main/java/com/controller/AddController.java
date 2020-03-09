package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.service.AddService;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
public class AddController {
	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response) {
		int number1 = Integer.parseInt(request.getParameter("number1"));
		int number2 = Integer.parseInt(request.getParameter("number2"));
		
		
		AddService service = new AddService();
		int sum= service.add(number1, number2);
		ModelAndView viewObject=new ModelAndView();
		viewObject.setViewName("display");
		viewObject.addObject("result",sum);
		return viewObject;
	}
}
