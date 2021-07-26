package com.ict.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyController {
	@RequestMapping("login.do")
	public ModelAndView loginCommand(HttpServletRequest request) {
		try {
			// 인증 코드 받기
			String code = request.getParameter("code");
			
			// 인증 코드를 이용해서 토큰 요청
			String access_Token = "";
			String refresh_Token = "";
			String reqURL = "https://kauth.kakao.com/oauth/token";
			
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			// POST 요청
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			
			BufferedWriter bw = 
					new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
			
			// 요구하는 파라미터값
			StringBuffer sb = new StringBuffer();
			sb.append("grant_type=authorization_code");
			sb.append("&client_id=c3274e95003d4408e38f5b0540ab6251");
			sb.append("&redirect_uri=http://localhost:8080/login.do");
			sb.append("&code="+code);
			bw.write(sb.toString());
			bw.flush();
			
			// 200 : 성공,  4XX : 클라이언트 오류,  500 : 서버 오류
			// System.out.println("responseCode : " + conn.getResponseCode());
			
			// 요청이 성공되면 메세지를 읽어오자(JSON 타입으로 되어 있음) 
			BufferedReader br = 
					new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			StringBuffer sb2 = new StringBuffer();
			while((line = br.readLine()) != null) {
				sb2.append(line);
			}
			br.close();
			bw.close();
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(sb2.toString());
			JSONObject j_obj = (JSONObject)obj;
			
			String access_token = (String)j_obj.get("access_token");
			
			// MyMember에서 사용하기 위해서 session에 저장
			request.getSession().setAttribute("access_token", access_token);
			
		return new ModelAndView("result");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	@RequestMapping(value = "member.do", produces = "text/html; charset=utf-8")
	@ResponseBody
	public String loginchk(HttpServletRequest request) {
		String access_token = (String)request.getSession().getAttribute("access_token");
		String header = "Bearer " + access_token;
		String apiURL = "https://kapi.kakao.com/v2/user/me";
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("Authorization", header);
		String responseBody = getResponseBody(apiURL, map);
		
		return responseBody;
		
	}
	
	public String getResponseBody(String apiURL, Map<String, String> map) {
		try {
			URL url = new URL(apiURL);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			
			for(Map.Entry<String, String> k : map.entrySet()) {
				conn.setRequestProperty(k.getKey(), k.getValue());
			}
			
			BufferedReader br = 
					new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String line = "";
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			return sb.toString();
		} catch (Exception e) {
			return null;
		}
	}
}











