package com.ict.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ict.vo.VO;

// 일반 컨트롤러는 ModelAndView를 리턴
// RestController는 리턴이 단순문자열 = text(text/html)
//				      객체   , Arraylist<VO> = JSON으로 브라우저에 표시
//확인 => http://localhost:8090/접근 URL
// Spring Rest API 기본은 JSON이다.
@Controller
public class MyController {

	@RequestMapping(value="text.do", produces = "text/html; charset=utf-8")
	@ResponseBody
	public String textCommand() {
		StringBuffer sb = new StringBuffer();
		sb.append("1,홍길동,25,서울/");
		sb.append("2,둘리,14,경기도/");
		sb.append("3,마이콜,22,강원도/");
		sb.append("4,도우너,18,충청도/");
		sb.append("5,또치,16,함경도");
		
		return sb.toString();
	}
	
	@RequestMapping(value="json.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public VO jsonCommand() {
		VO vo = new VO();
		vo.setIdx("1");
		vo.setName("마루치"); 
		vo.setAge("19");
		vo.setAddr("서울시");
		
		return vo;
	}
	
	@RequestMapping(value="json2.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<VO> json2Command() {
		List<VO> list = new ArrayList<VO>();
		VO vo = new VO();
		vo.setIdx("1");
		vo.setName("마루치"); 
		vo.setAge("19");
		vo.setAddr("서울시");
		list.add(vo);
		
		vo = new VO();
		vo.setIdx("2");
		vo.setName("아라치"); 
		vo.setAge("17");
		vo.setAddr("경기도");
		list.add(vo);
		
		
		vo = new VO();
		vo.setIdx("3");
		vo.setName("파란해골13호"); 
		vo.setAge("18");
		vo.setAddr("제주도");
		list.add(vo);
		
		return list;
	}
	
	@RequestMapping(value="json3.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String json3Command() {
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL("http://openapi.seoul.go.kr:8088/sample/json/SeoulLibraryTime/1/5/");
			URLConnection conn = url.openConnection();
			BufferedReader br =
					new BufferedReader(new InputStreamReader(conn.getInputStream(),"utf-8"));
			String msg = "";
			while((msg = br.readLine())!=null) {
				sb.append(msg+"\n");
			}
		} catch (Exception e) {
		}
		
		return sb.toString();
	}
	
}
