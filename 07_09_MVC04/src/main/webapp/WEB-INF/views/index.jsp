<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{width: 600px; margin: 0 auto; border-collapse: collapse;}
	table, th, td { border: 1px solid gray; text-align: center;}
	fieldset {width: 600px; margin: auto;}
	div{margin: auto;}
	input { padding: 5px; }
</style>
</head>
<body>
	<div>
	<form action="grades.do">
		<fieldset>
			<legend>성적입력</legend>
			<table>
				<tbody>
					<tr><th>이름</th><td><input type="text" name="name" placeholder="이름입력" required></td> </tr>
					<tr><th>국어</th><td><input type="number" name="kor" placeholder="국어점수입력" required></td> </tr>
					<tr><th>영어</th><td><input type="number" name="eng" placeholder="영어점수입력" required></td> </tr>
					<tr><th>수학</th><td><input type="number" name="math" placeholder="수학점수입력" required></td> </tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2"><input type="submit" value="성적확인"> </td>
						<input type="hidden" name = "cPage" value="3" >
					</tr>
				</tfoot>
			</table>
		</fieldset>
	</form>
	</div>
</body>
</html>