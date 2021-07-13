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

// �Ϲ� ��Ʈ�ѷ��� ModelAndView�� ����
// RestController�� ������ �ܼ����ڿ� = text(text/html)
//				      ��ü   , Arraylist<VO> = JSON���� �������� ǥ��
//Ȯ�� => http://localhost:8090/���� URL
// Spring Rest API �⺻�� JSON�̴�.
@Controller
public class MyController {

	@RequestMapping(value="text.do", produces = "text/html; charset=utf-8")
	@ResponseBody
	public String textCommand() {
		StringBuffer sb = new StringBuffer();
		sb.append("1,ȫ�浿,25,����/");
		sb.append("2,�Ѹ�,14,��⵵/");
		sb.append("3,������,22,������/");
		sb.append("4,�����,18,��û��/");
		sb.append("5,��ġ,16,�԰浵");
		
		return sb.toString();
	}
	
	@RequestMapping(value="json.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public VO jsonCommand() {
		VO vo = new VO();
		vo.setIdx("1");
		vo.setName("����ġ"); 
		vo.setAge("19");
		vo.setAddr("�����");
		
		return vo;
	}
	
	@RequestMapping(value="json2.do", produces = "application/json; charset=utf-8")
	@ResponseBody
	public List<VO> json2Command() {
		List<VO> list = new ArrayList<VO>();
		VO vo = new VO();
		vo.setIdx("1");
		vo.setName("����ġ"); 
		vo.setAge("19");
		vo.setAddr("�����");
		list.add(vo);
		
		vo = new VO();
		vo.setIdx("2");
		vo.setName("�ƶ�ġ"); 
		vo.setAge("17");
		vo.setAddr("��⵵");
		list.add(vo);
		
		
		vo = new VO();
		vo.setIdx("3");
		vo.setName("�Ķ��ذ�13ȣ"); 
		vo.setAge("18");
		vo.setAddr("���ֵ�");
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
