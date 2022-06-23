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
	<h3>테이블 명 member 를 만드는 쿼리를 작성하시오 (실행은 하지 말 것) </h3>
	<table>
		<tr>
			<th>Field</th>
			<th>TYPE</th>
			<th>SIZE</th>
		</tr>
		<tr>
			<td>ID</td>
			<td>VARCHAR</td>
			<td>50</td>
		</tr>
		<tr>
			<td>PW</td>
			<td>VARCHAR</td>
			<td>100</td>
		</tr>
		<tr>
			<td>NAME</td>
			<td>VARCHAR</td>
			<td>50</td>
		</tr>
		<tr>
			<td>AGE</td>
			<td>INT</td>
			<td>3</td>
		</tr>
		<tr>
			<td>GENDER</td>
			<td>VARCHAR</td>
			<td>4</td>
		</tr>
		<tr>
			<td>EMAIL</td>
			<td>VARCHAR</td>
			<td>100</td>
		</tr>									
	</table>
	
	<a href="stmt.jsp">statement 실행</a>
	<br/>
	<a href="form.jsp">prepared statement 실행</a>
</body>
</html>