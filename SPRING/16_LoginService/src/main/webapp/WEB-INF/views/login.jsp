<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style>
	</style>
</head>
<body>
	<form action="login" method="post">	
		<table>
			<tr>
				<th>아이디</th>
				<th><input type="text" name="id" placeholder="아이디를 입력하세요"></th>
				<th rowspan="2"><button>로그인</button></th>
			</tr>
			<tr>
				<th>비밀번호</th>
				<th><input type="text" name="pw" placeholder="비밀번호를 입력하세요"></th>
			</tr>
		</table>
	</form>
</body>
<script>
</script>
</html>