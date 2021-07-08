package com.ict.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HiController {
	
	@RequestMapping(value="hi.do", method = RequestMethod.GET)
	public ModelAndView HiCommand() {
		ModelAndView mv = new ModelAndView("result");
		mv.addObject("msg", "Welcome Spring MVC");
		return mv;
	}
}
