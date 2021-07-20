<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2> 결과 보기 </h2>
	<c:choose>
		<c:when test="${res==1}">
			<h2>
				${vo.consumerid } 고객님 <br>
				${vo.amount } 개 결재 하셨습니다. <br>
				${vo.countnum } 개 티켓을 발급합니다. <br>
			</h2>
		</c:when>
		<c:otherwise>
			<h2> 결재가 취소 되었습니다.</h2>
		</c:otherwise>
	</c:choose>
	<hr>
	<h2> 결과 보기 </h2>
	<c:choose>
		<c:when test="${res==1}">
			<h2>
				${cvo.consumerid } 고객님 <br>
				${cvo.amount } 개 결재 하셨습니다. <br>
				${tvo.countnum } 개 티켓을 발급합니다. <br>
			</h2>
		</c:when>
		<c:otherwise>
			<h2> 결재가 취소 되었습니다.</h2>
		</c:otherwise>
	</c:choose>
	
</body>
</html>