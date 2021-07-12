package com.ict.controller;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ict.service.MyService;
import com.ict.vo.VO;

@Controller
public class MyController {
	
	@Autowired
	private MyService myService;
	
	@RequestMapping("list.do")
	public ModelAndView listCommand() {
		try {
			ModelAndView mv = new ModelAndView("list");
			List<VO> list = myService.getList();
			mv.addObject("list", list);
			return mv;
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("error") ;
		}
	}
	
	@RequestMapping("write.do")
	public ModelAndView writeCommand() {
		return new ModelAndView("write");
	}
	
	@RequestMapping("write_ok.do")
	public ModelAndView writeokCommand(VO vo) {
		try {
			ModelAndView mv = new ModelAndView("redirect:list.do");
			myService.getInsert(vo);
			return mv;
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("error");
		}
	}
	
	@RequestMapping("onelist.do")
	public ModelAndView oneListCommand(@RequestParam("idx")String idx) {
		try {
			ModelAndView mv = new ModelAndView("onelist");
			VO vo = myService.getOneList(idx);
			mv.addObject("vo", vo);
			return mv;
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("error");
		}
	}
	
	@RequestMapping("delete.do")
	public ModelAndView deleteCommand(@ModelAttribute("vo")VO vo){
		return new ModelAndView("delete");
	}
	
	@RequestMapping("delete_ok.do")
	public ModelAndView deleteokCommand(@ModelAttribute("idx")String idx) {
		try {
			myService.getDelete(idx);
			return new ModelAndView("redirect:list.do");
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("error");
		}
	}
	
	@RequestMapping("update.do")
		public ModelAndView updateConmmand(@ModelAttribute("idx")String idx) {
		try {
			ModelAndView mv = new ModelAndView("update");
			VO vo = myService.getOneList(idx);
			mv.addObject("vo", vo);
			return mv;
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("error");
		}	
	}
	
	@RequestMapping("update_ok.do")
	public ModelAndView updateokCommand(VO vo) {
		try {
			myService.getUpdate(vo);
			return new ModelAndView("redirect:list.do?idx="+vo.getIdx());
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("error");
		}
	}
}
