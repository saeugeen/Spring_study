package com.ict.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
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
			List<VO> list =  myService.selectAll();
			mv.addObject("list", list);
			return mv;
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("error");
		}
	}
	@RequestMapping("write.do")
	public ModelAndView writeCommand() {
		return new ModelAndView("write");
	}
	@RequestMapping(value = "write_ok.do" ,method = RequestMethod.GET )
	public ModelAndView writeOKGetCommand() {
		return new ModelAndView("redirect:write.do");
	}
	
	@RequestMapping(value = "write_ok.do" ,method = RequestMethod.POST )
	public ModelAndView writeOKCommand(VO vo, HttpServletRequest request) {
		try {
			String path = request.getSession().getServletContext().getRealPath("/resources/upload");
			MultipartFile file = vo.getF_name();
			if(file.isEmpty()) {
				vo.setFile_name("");
			}else {
				vo.setFile_name(file.getOriginalFilename());
			}
			int res = myService.insertGuestBook2(vo);
			byte[] in = file.getBytes();
			File out = new File(path, vo.getFile_name());
			FileCopyUtils.copy(in, out);
			return new ModelAndView("redirect:list.do");
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("redirect:list.do");
		}
	}
	
	@RequestMapping("onelist.do")
	public ModelAndView onelistCommand(@RequestParam("idx")String idx) {
		try {
			ModelAndView mv = new ModelAndView("onelist");
			VO vo = myService.selectOne(idx);
			mv.addObject("vo", vo);
			return mv;
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("error");
		}
	}
	
	@RequestMapping("download.do")
	public void downLoadCommand(@RequestParam("file_name")String file_name,
			HttpServletRequest request, HttpServletResponse response) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			String path = request.getSession().getServletContext()
					.getRealPath("/resources/upload/"+file_name);
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition",
					"attachment; filename="+URLEncoder.encode(file_name,"utf-8"));
			
			File file = new File(new String(path.getBytes("utf-8")));
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(response.getOutputStream());
			
			FileCopyUtils.copy(bis, bos);
		} catch (Exception e) {
		} finally {
			try {
				bos.close();
				bis.close();
				fis.close();
			} catch (Exception e2) {
			}
		}	
	}
	
	@RequestMapping("delete.do")
	public ModelAndView deleteCommand(@ModelAttribute("vo")VO vo) {
		return new ModelAndView("delete");
	}
	
	@RequestMapping("delete_ok.do")
	public ModelAndView deleteokCommand(@RequestParam("idx")String idx) {
		try {
			myService.deleteGuestBook2(idx);
			return new ModelAndView("redirect:list.do");
		} catch (Exception e) {
			System.out.println(e);
			return new ModelAndView("error") ;
		}
	}
}












