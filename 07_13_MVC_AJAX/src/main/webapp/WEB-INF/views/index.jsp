<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div{text-align: center;}
	table{width: 500px; margin: 0px auto;}
	table,th,td{
	  border: 1px solid skyblue;
	  text-align: center;
	  border-collapse: collapse;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
   $(function() {
	 	$("#btn1").click(function() {
			$("#result").empty();
			$.ajax({
				url:"text.do",
				method :"post",
				dataType : "text",
				success : function(data){
					var table = "<table>";
					table += "<thead>";
					table +="<tr><th>번호</th><th>이름</th><th>나이</th><th>주소</th></tr>";
					table += "</thead><tbody>";
					var person = data.split("/");
					for(var k in person){
						table += "<tr>";
						var item = person[k].split(",");
						for (var i = 0; i < item.length; i++) {
							table +="<td>"+ item[i] + "</td>";
						}
						table += "</tr>";
					}
					table += "</tbody>";
					table +="</table>";
					$("#result").append(table);
				},
				error:function(){
				 	alert("읽기실패");
				}
			});
		});
	 	
	 	$("#btn2").click(function() {
			$("#result").empty();
			$.ajax({
				url:"json2.do",
				method :"post",
				dataType : "json",
				success : function(data){
					var table = "<table>";
					table += "<thead>";
					table +="<tr><th>번호</th><th>이름</th><th>나이</th><th>주소</th></tr>";
					table += "</thead><tbody>";
					$.each(data, function() {
						table += "<tr>";
						table += "<td>"+this["idx"]+"</td>";
						table += "<td>"+this["name"]+"</td>";
						table += "<td>"+this["age"]+"</td>";
						table += "<td>"+this["addr"]+"</td>";
						table += "</tr>";
					});
					
					table += "</tbody>";
					table +="</table>";
					$("#result").append(table);
				},
				error:function(){
				 	alert("읽기실패");
				}
			});
		});
	 	
	 	$("#btn3").click(function() {
			$("#result").empty();
			$.ajax({
				url:"json3.do",
				method :"post",
				dataType : "json",
				success : function(data){
					var table = "<table>";
					table += "<thead>";
					table +="<tr><th>도서관이름</th><th>주소</th><th>전화번호</th><th>휴관일</th></tr>";
					table += "</thead><tbody>";
					$.each(data, function() {
						$.each(this["row"], function() {
							table += "<tr>";
							table += "<td>"+this["LBRRY_NAME"]+"</td>";
							table += "<td>"+this["ADRES"]+"</td>";
							table += "<td>"+this["TEL_NO"]+"</td>";
							table += "<td>"+this["FDRM_CLOSE_DATE"]+"</td>";
							table += "</tr>";
						})
					});
					
					table += "</tbody>";
					table +="</table>";
					$("#result").append(table);
				},
				error:function(){
				 	alert("읽기실패");
				}
			});
		});
   });
</script>
<script type="text/javascript"></script>
</head>
<body>
	<h2> Ajax 예제 </h2>
	<hr>
	<button id="btn1">텍스트</button>
	<button id="btn2">JSON</button>
	<button id="btn3">외부JSON</button>
	<br>
	<hr>
	<div id="result"></div>
</body>
</html>