<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style>
		table, th, td{
			border: 1px solid black;
			border-collapse: collapse;
			padding: 5px;
		}
	</style>
</head>
<body>
		<form action="join_map" method="post">
			<table>
				<tr>
					<th>*ID</th>
					<td><input type="text" name="id"/></td>
				</tr>
				<tr>
					<th>*PW</th>
					<td><input type="text" name="pw"/></td>
				</tr>
				<tr>
					<th>*NAME</th>
					<td><input type="text" name="name"/></td>
				</tr>
				<tr>
					<th>*AGE</th>
					<td><input type="text" name="age"/></td>
				</tr>
				<tr>
					<th>*GENDER</th>
					<td>
						<input type="radio" name="gender" value="남"/>남자
						&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="gender" value="여"/>여자
					</td>
				</tr>
				
				<!-- 이메일을 적지 않으면 '없음' 으로 DB 에 들어가도록 처리할 예정 -->
				<tr>
					<th>EMAIL</th>
					<td><input type="email" name="email"/></td>
				</tr>
				<tr>
					<th colspan="2"><input type="submit" value="회원가입"></th>
				</tr>				
			</table>
		</form>
</body>
<script>
	var msg = "${msg}";
	if(msg != ""){
		alert(msg);
	}
</script>
</html>