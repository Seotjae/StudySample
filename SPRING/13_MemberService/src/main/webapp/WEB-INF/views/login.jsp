<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style>
	</style>
</head>
<body>
	<form action="login" method="post">
		<table>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="id" placeholder="아이디를 입력하세요">
				</td>
				<th>
					<button>로그인</button>
				</th>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="pw" placeholder="비밀번호를 입력하세요">
				</td>
				<th>
					<input onclick="location.href='joinForm'" type="button" value="회원가입">
				</th>
			</tr>
		</table>
	</form>
</body>
<script>
	if (${loginResult == 0}) {
		alert('아이디 또는 비밀번호를 확인하세요.');
	}


</script>
</html>