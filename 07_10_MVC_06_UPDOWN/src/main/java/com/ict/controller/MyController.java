package com.ict.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@Controller
public class MyController {
	
	// GET방식은 파일업로드를 할 수 없습니다.
	@RequestMapping(value = "f_up.do", method =RequestMethod.GET )
	public ModelAndView getUpCommand() {
		return new ModelAndView("index");
	}
	
	@RequestMapping(value = "f_up.do", method=RequestMethod.POST )
	public ModelAndView postUpCommand(HttpServletRequest request) {
	//public ModelAndView postUpCommand(HttpSession session) {
		ModelAndView mv = new ModelAndView("result");
		try {
			   String path = request.getSession().getServletContext().getRealPath("/resources/upload");
			// String path = session.getServletContext().getRealPath("/resources/upload");
			
			MultipartRequest mr = 
					new MultipartRequest(request, path, 100*1024*1024, "utf-8", new DefaultFileRenamePolicy());
			
			String name = mr.getParameter("name");
			String file_name = mr.getFilesystemName("file_name");
			String file_type = mr.getContentType("file_name");
			
			File file = mr.getFile("file_name");
			long size = file.length() / 1024 ; // KB;
			SimpleDateFormat day = new SimpleDateFormat("yyyy녀 MM월 dd일 hh시 mm분 E요일");
			String lastday = day.format(file.lastModified());
			
			mv.addObject("name",name );
			mv.addObject("file_name", file_name);
			mv.addObject("file_type",file_type );
			mv.addObject("size", size);
			mv.addObject("lastday", lastday);
		} catch (Exception e) {
		}
		return mv;
	}
	
	@RequestMapping("down.do")
	public void getFileDown(HttpServletRequest request, HttpServletResponse response) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			String file_name = request.getParameter("file_name");
			String path = request.getSession().getServletContext()
					.getRealPath("/resources/upload/"+file_name);
			// 브라우저 설정
			response.setContentType("application/x-msdownload");
			response.setHeader("Content-Disposition",
					"attachment; filename="+URLEncoder.encode(file_name,"utf-8"));
			// 실제 I/O
			File file = new File(new String(path.getBytes("utf-8")));
			int b;
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(response.getOutputStream());
			while((b=bis.read())!=-1) {
				bos.write(b);
			}
			bos.flush();
			
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
}










