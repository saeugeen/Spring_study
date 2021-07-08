<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send_go() {
		location.href="say.do";
	}
</script>
</head>
<body>
	<h2>첫번째 Spring MVC 예제</h2>
	<h2><a href="hello.do">hello</a></h2>
	<h2><a href="hi.do"> hi</a></h2>
	<h2><a href="arr.do">Array</a></h2>
	<h2><button onclick="send_go()">클릭</button></h2>
</body>
</html>