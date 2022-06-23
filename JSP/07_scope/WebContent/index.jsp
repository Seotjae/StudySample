<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<form action="application.jsp" method="post">
		<table>
			<tr>
				<td colspan="2">Application 에 저장될 내용</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="userId"/></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><input type="text" name="userName"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="전송"/></td>
			</tr>
		</table>
	</form>
</body>
</html>