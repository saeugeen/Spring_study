<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#out").empty();
		$.ajax({
			url : "member.do",
			method : "post",
			dataType : "json",
			success : function(data) {
				var nickname ="";
				var email="";
				$.each(data, function() {
					var profile = this['profile'];
					$.each(profile,function(){
						nickname = profile["nickname"];
				
					});
					email = this['email'];
					
				});
				$("#out").append(nickname+"("+email+")님 환영합니다.");
			},
			error : function() {
				alert("읽기실패");
			}
		});
	});
</script>
</head>
<body>
	<h1 id="btn">결과 보기</h1>
	<div id="out"></div>
</body>
</html>