package com.ict.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ict.service.MyService;
import com.ict.vo.CVO;
import com.ict.vo.TVO;
import com.ict.vo.VO;

@Controller
public class MyController {
	@Autowired MyService myService ;
	@RequestMapping("result.do")
	public ModelAndView resultCommand(VO vo) {
		ModelAndView mv = new ModelAndView("result");
		try {
			vo.setCountnum(vo.getAmount());
			int res = myService.insertCT(vo);

			// 성공하면 1, 실패하면 0 ;
			mv.addObject("res", res);
			mv.addObject("vo", vo);
			return mv;
		} catch (Exception e) {
			mv.addObject("res", 0);
			return mv;
		}
	}
	
	@RequestMapping("result2.do")
	public ModelAndView resultCommand(@ModelAttribute("cvo")CVO cvo,
			@ModelAttribute("tvo")TVO tvo) {
		ModelAndView mv = new ModelAndView("result");
		try {
			tvo.setCountnum(cvo.getAmount());
			int res = myService.insertCT2(cvo, tvo);

			// 성공하면 1, 실패하면 0 ;
			mv.addObject("res", res);
			// mv.addObject("cvo", cvo);
			// mv.addObject("tvo", tvo);
			return mv;
		} catch (Exception e) {
			mv.addObject("res", 0);
			return mv;
		}
	}
}
