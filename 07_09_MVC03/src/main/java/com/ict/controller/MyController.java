package com.ict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.service.CalcService;

@Controller
public class MyController {
	// root-context.xml에서 객체 생성해서 사용하자
	// CalcService calc = new CalcService();
	
	@Autowired
	private CalcService calc;
	
	public void setCalc(CalcService calc) {
		this.calc = calc;
	}
	
	@RequestMapping("add.do")
	public ModelAndView addCommand() {
		ModelAndView mv = new ModelAndView("result");
		int result = calc.plus();
		mv.addObject("result",result);
		return mv;
	}
	@RequestMapping("sub.do")
	public ModelAndView subCommand() {
		ModelAndView mv = new ModelAndView("result");
		int result = calc.minus();
		mv.addObject("result",result);
		return mv;
	}
	@RequestMapping("mul.do")
	public ModelAndView mulCommand() {
		ModelAndView mv = new ModelAndView("result");
		int result = calc.multi();
		mv.addObject("result",result);
		return mv;
	}
	@RequestMapping("dev.do")
	public ModelAndView divCommand() {
		ModelAndView mv = new ModelAndView("result");
		int result = calc.divice();
		mv.addObject("result",result);
		return mv;
	}
}
