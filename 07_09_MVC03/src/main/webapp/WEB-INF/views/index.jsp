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
	<button onclick="add_go()">���ϱ�</button>
	<button onclick="sub_go()">����</button>
	<button onclick="mul_go()">���ϱ�</button>
	<button onclick="dev_go()">������</button>
	<hr>
	
	<button onclick="add_go2()">���ϱ�</button>
	<button onclick="sub_go2()">����</button>
	<button onclick="mul_go2()">���ϱ�</button>
	<button onclick="dev_go2()">������</button>
</body>
</html>