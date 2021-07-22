<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#bbs table {
	    width:800px;
	    margin:0 auto;
	    margin-top:20px;
	    border:1px solid black;
	    border-collapse:collapse;
	    font-size:14px;
	    
	}
	
	#bbs table caption {
	    font-size:20px;
	    font-weight:bold;
	    margin-bottom:10px;
	}
	
	#bbs table th {
	    text-align:center;
	    border:1px solid black;
	    padding:4px 10px;
	}
	
	#bbs table td {
	    text-align:left;
	    border:1px solid black;
	    padding:10px 10px;
	}
	
	.no {width:15%}
	.subject {width:30%}
	.writer {width:20%}
	.reg {width:20%}
	.hit {width:15%}
	.title{background:lightsteelblue}
	.odd {background:silver}
	
	/* 댓글 */
	.div1{
		width: 800px;
		margin: auto;
	}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		function getList(){
			$("#tbody").empty();
			$.ajax({
				url : "clist.do",
				method: "post",
				data:"b_idx=${bvo.b_idx}",
				dataType : "json",
				success : function(data) {
				  var tbody = "";
				  $.each(data,function(){
					  tbody +="<tr>"; 
					  tbody +="<td><textarea rows='4' cols='70' name='content' readonly>"+this["content"]+"</textarea></td>"	;
					  tbody += "<td><input style='height: 70px;' type='button' value='댓글 삭제' id='del' c_idx="+this["c_idx"]+"></td>";
					  tbody +="</tr>";
				  });
				  $("#tbody").append(tbody);
				},
				error : function() {
					alert("읽기실패");
				}
			});
		}
		$("#btn1").click(function() {
			$.ajax({
				url : "c_insert.do",
				method: "post",
				data: $("#myForm").serialize(),
				dataType : "text",
				success : function(data) {
					if(data=='1'){
						getList();
					}
					$("#myForm")[0].reset(); 
				},
				error : function() {
					alert("읽기실패");
				}
			});
		});
		$("table").on("click","#del", function() {
			$.ajax({
				url : "c_delete.do",
				method: "post",
				data: "c_idx="+ $(this).attr("c_idx"),
				dataType : "text",
				success : function(data) {
					if(data=='1'){
						getList();
					}
					$("#myForm2")[0].reset(); 
				},
				error : function() {
					alert("읽기실패");
				}
			});
		});
		
		getList();
	});
</script>
<script type="text/javascript">
	function list_go(f) {
		f.action="list.do?cPage=${cPage}";
		f.submit();
	}
	function update_go(f) {
		f.action="update.do?cPage=${cPage}&b_idx=${bvo.b_idx}";
		f.submit();
	}
	function delete_go(f) {
		f.action="delete.do?cPage=${cPage}&b_idx=${bvo.b_idx}";
		f.submit();
	}
</script>

</head>
<body>
	<div id="bbs">
	<form method="post" encType="multipart/form-data">
		<table summary="게시판 내용보기">
			<caption>게시판 내용보기</caption>
			<tbody>
				<tr>
					<th>제목:</th>
					<td>${bvo.subject }</td>
				</tr>
				<tr>
					<th>이름:</th>
					<td>${bvo.writer }</td>
				</tr>
				<tr>
					<th>내용:</th>
					<td><script src="//cdn.ckeditor.com/4.16.1/standard/ckeditor.js"></script>
						<textarea name="content" cols="50" rows="8" readonly>${bvo.content}</textarea>
						<script type="text/javascript">
							CKEDITOR.replace('content');
						</script>
					</td>
				</tr>
				<tr>
					<th>첨부파일:</th>
					<c:choose>
						<c:when test="${!empty bvo.file_name}">
							<td style="text-align: center">
								<img alt="" src="resources/upload/${bvo.file_name }" style="width: 100px;"><br>
								<a href="download.do?file_name=${bvo.file_name }">${bvo.file_name}</a> 
							</td>
						</c:when>
						<c:otherwise>
							<td><b>첨부파일없음</b></td>
						</c:otherwise>
					</c:choose>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
						<input type="button" value="수정" onclick="update_go(this.form)">
						<input type="button" value="삭제" onclick="delete_go(this.form)">
						<input type="button" value="목록" onclick="list_go(this.form)"/>
					</td>
				</tr>
			</tbody>
		</table>
	</form>
	</div>
	<br><br>
	<%-- 댓글 출력 --%>
	<div class="div1">
	<hr>
		<div style="margin: 10px; 0px;">
			<form method="post" id="myForm2">
				<table>
					<tbody id="tbody"></tbody>
				</table>
			</form>
		</div>
	</div>
	<br>
	<%-- 댓글 입력 --%>
	<div class="div1">
		<form method="post" id="myForm">
			<table>
				<tbody>
					<tr>
						<!-- 댓글 쓴사람과 로그인 아이디가 같으면 삭제,수정 가능하게 만들어야 됨 -->
						<td><textarea rows="4" cols="70" name="content"></textarea></td>
						<td><input style="height: 70px;" type="button" id="btn1" value="댓글"></td>
						<input type="hidden" name="b_idx" value="${bvo.b_idx }">
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>




















