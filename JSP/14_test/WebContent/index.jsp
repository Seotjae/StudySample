<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	table, td, th{
	border: 1px solid black;
	border-collapse: collapse;
	padding: 5px 10px;
	}
</style>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>PW</th>
			<th>NAME</th>
			<th>AGE</th>
			<th>GENDER</th>
			<th>E-MAIL</th>
		</tr>
		<form action="insert.jsp" method="post">
			<tr>
				<td><input type="text" name="id"/></td>
				<td><input type="text" name="pw"/></td>
				<td><input type="text" name="name"/></td>
				<td><input type="text" name="age"/></td>
				<td><input type="text" name="gender"/></td>
				<td><input type="text" name="email"/></td>
			</tr>
			<tr>
				<td colspan="6"><button>입력</button></td>
			</tr>
		</form>
	</table>
</body>
</html>