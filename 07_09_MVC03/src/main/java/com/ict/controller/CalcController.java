package com.ict.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.service.CalcService;

@Controller
public class CalcController {
	
	@Inject
	private CalcService calc;
	
	public void setCalc(CalcService calc) {
		this.calc = calc;
	}
	
	@RequestMapping("calc.do")
	public ModelAndView calcCommand(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("result");
		String cmd = request.getParameter("cmd");
		int result =0;
		switch (cmd) {
		case "1": result = calc.plus(); break;
		case "2": result = calc.minus(); break;
		case "3": result = calc.multi(); break;
		case "4": result = calc.divice(); break;
			
		}
		
		mv.addObject("result", result);
		return mv;
	}
}
