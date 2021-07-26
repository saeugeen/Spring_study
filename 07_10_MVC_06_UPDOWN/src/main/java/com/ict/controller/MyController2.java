package com.ict.controller;

import java.io.File;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ict.vo.VO;

@Controller
public class MyController2 {
	// GET방식은 파일업로드를 할 수 없습니다.
		@RequestMapping(value = "f_up2.do", method =RequestMethod.GET )
		public ModelAndView getUpCommand() {
			return new ModelAndView("index");
		}
		
		@RequestMapping(value = "f_up2.do", method=RequestMethod.POST )
		public ModelAndView postUpCommand(VO vo ,HttpServletRequest request) {
			ModelAndView mv = new ModelAndView("result");
			try {
				String path = request.getSession().getServletContext().getRealPath("/resources/upload");
				String name = vo.getName();
				
				//업로드할 당시의 이름만 사용가능, 같은 이름이 있으면 업로드 안됨(주의)
				String file_name = vo.getFile_name().getOriginalFilename();
							
				String file_type = vo.getFile_name().getContentType();
				long size = vo.getFile_name().getSize() / 1024 ; // KB
				SimpleDateFormat day = new SimpleDateFormat("yyyy녀 MM월 dd일 hh시 mm분 E요일");
				
				// 올릴파일을 byte[]로 만든다.
				byte[] in = vo.getFile_name().getBytes();
				
				// 저장장소와 이름 지정
				File out = new File(path, file_name);
				
				String lastday = day.format(out.lastModified());
				
				// 복사(upload)
				FileCopyUtils.copy(in, out);
				
				
				mv.addObject("name",name );
				mv.addObject("file_name", file_name);
				mv.addObject("file_type",file_type );
				mv.addObject("size", size);
				mv.addObject("lastday", lastday);
			
			} catch (Exception e) {
				System.out.println(e);
			}
			return mv;
		}
}










