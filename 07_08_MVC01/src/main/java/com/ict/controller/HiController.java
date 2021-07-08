package com.ict.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HiController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("result");

		// 비즈니스 로직 처리(Service -> ServiceImpl -> DAO ->DAOImpo ->DB)

		// 데이터 저장
		request.setAttribute("name", "태권브이");
		request.getSession().setAttribute("age", 39);
		mv.addObject("addr", "국회의사당 지하");

		return mv;
	}
}
