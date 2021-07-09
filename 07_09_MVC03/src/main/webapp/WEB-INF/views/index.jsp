<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function add_go() {
		location.href="add.do";
	}
	function sub_go() {
		location.href="sub.do";
	}
	function mul_go() {
		location.href="mul.do";
	}
	function dev_go() {
		location.href="dev.do";
	}
	
	
	function add_go2() {
		location.href="calc.do?cmd=1";
	}
	function sub_go2() {
		location.href="calc.do?cmd=2";
	}
	function mul_go2() {
		location.href="calc.do?cmd=3";
	}
	function dev_go2() {
		location.href="calc.do?cmd=4";
	}
	
</script>
</head>
<body>
	<button onclick="add_go()">더하기</button>
	<button onclick="sub_go()">빼기</button>
	<button onclick="mul_go()">곱하기</button>
	<button onclick="dev_go()">나누기</button>
	<hr>
	
	<button onclick="add_go2()">더하기</button>
	<button onclick="sub_go2()">빼기</button>
	<button onclick="mul_go2()">곱하기</button>
	<button onclick="dev_go2()">나누기</button>
</body>
</html>