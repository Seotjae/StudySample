<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style>
		table,th,td{
			border: 1px solid black;
			border-collapse: collapse;
			padding: 5px;
		}
	</style>
</head>
<body>
	<form action="login" method="post">
		<table>
			<tr>
				<th>ID</th>
				<td><input type="text" name="id"/></td>
			</tr>
			<tr>
				<th>PW</th>
				<td><input type="text" name="pw"/></td>
			</tr>
			<tr>
				<th colspan="2">
				<button>LOG IN</button>
				<!-- Spring 에서는 .jsp 이동도 컨트롤러를 타야한다 (보안상 이유) -->
				<input type="button" value="회원가입" onclick="location.href='joinForm'"/>	
				</th>
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