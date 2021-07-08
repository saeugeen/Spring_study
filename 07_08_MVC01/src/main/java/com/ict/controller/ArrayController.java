package com.ict.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ArrayController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("out/result2");
		
		String[] dogName = {"땅콩이","토리","댕댕이","바둑이"};
		
		ArrayList<String> carName = new ArrayList<String>();
		carName.add("제네시스");
		carName.add("BMW");
		carName.add("벤츠");
		carName.add("아우디");
		
		mv.addObject("dogName", dogName);
		mv.addObject("carName", carName);
		
		return mv;
	}
}
