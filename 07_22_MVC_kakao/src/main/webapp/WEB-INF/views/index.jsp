<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 1. 인증코드 요청 -->
	<a href="https://kauth.kakao.com/oauth/authorize?client_id=c3274e95003d4408e38f5b0540ab6251&redirect_uri=http://localhost:8080/login.do&response_type=code">
		<img src="resources/images/kakao_login.png">
	</a>
</body>
</html>