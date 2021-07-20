<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h2> 결재 하기 </h2>
	<form method="post" action="result.do">
		<p>고객아이디 : <input type="text" name="consumerid" required></p>
		<p>티켓구매수 : <input type="number" name="amount"  required></p>
		<input type="submit" value="구매하기" >
	</form>
	<hr>
	
	<h2> 결재 하기 </h2>
	<form method="post" action="result2.do">
		<p>고객아이디 : <input type="text" name="consumerid" required></p>
		<p>티켓구매수 : <input type="number" name="amount"  required></p>
		<input type="submit" value="구매하기" >
	</form>
	
</body>
</html>