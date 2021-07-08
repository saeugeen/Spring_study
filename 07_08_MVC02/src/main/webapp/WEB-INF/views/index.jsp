<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>첫번째 Spring MVC어노테이션 예제</h2>
	<form action="hello.do" method="get">
		<input type="submit" value="hello">
	</form>
	
	<form action="hello.do" method="post">
		<input type="submit" value="hello">
	</form>
	
	<hr>
	
	<h2><a href="hi.do">Hi</a></h2>
</body>
</html>