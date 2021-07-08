package com.ict.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//어노테이션이 아니면 무조건 Controller를 상속받아야 한다.
public class HelloController implements Controller{
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		//ViewName을 이용해서 받을 jsp를 완성시킨다.
		mv.setViewName("result");
		
		//비즈니스 로직 처리(Service -> ServiceImpl -> DAO ->DAOImpo ->DB)
		
		//데이터 저장
		request.setAttribute("name", "홍길동");
		request.getSession().setAttribute("age", 24);
		mv.addObject("addr","서울시 마포구");
		
		
		return mv;
	}
}
