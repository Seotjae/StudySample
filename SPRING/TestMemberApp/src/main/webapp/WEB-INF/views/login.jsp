<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style>
		table,td,th{
			border: 1px solid black;
			border-collapse: collapse;
			padding: 5px
		}
	</style>
</head>
<body>
	<form action="login" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" placeholder="아이디를 입력하세요."/></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pw" placeholder="비밀번호를 입력하세요."/></td>
			</tr>
			<tr>
				<th colspan="2">
				<button>로그인</button>
				<input type="button" value="회원가입" onclick="location.href='joinForm'"/>
				</th>
			</tr>			
		</table>
	</form>

</body>
<script>
</script>
</html>