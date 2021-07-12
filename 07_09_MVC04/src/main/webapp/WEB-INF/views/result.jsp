<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>결과보기</h2>
	<h3>이름 : ${name}</h3>
	<h3>총점 : ${sum}</h3>
	<h3>평균 : ${avg}</h3>
	<h3>학점 : ${hak}</h3>
	<hr>
	<h2>결과보기(vo)</h2>
	<h3>이름 : ${vo.name}</h3>
	<h3>총점 : ${vo.sum}</h3>
	<h3>평균 : ${vo.avg}</h3>
	<h3>학점 : ${vo.hak}</h3>
	<hr>
	
	<h2>결과보기(mvo)</h2>
	<h3>이름 : ${mvo.name}</h3>
	<h3>총점 : ${mvo.sum}</h3>
	<h3>평균 : ${mvo.avg}</h3>
	<h3>학점 : ${mvo.hak}</h3>
</body>
</html>