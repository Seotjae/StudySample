<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style></style>
</head>
<body>
	<!-- 2. 회원가입에 필요한 정보를 컨트롤러로 전송한다 (회원가입 요청)-->
	<form action="join" method="post">
		ID : <input type="text" name="id"/> <br/>
		PW : <input type="text" name="pw"/><br/>
		NAME : <input type="text" name="name"/><br/>
		AGE : <input type="text" name="age"/><br/>
		GENDER : <input type="text" name="gender"/><br/>
		EMAIL : <input type="text" name="email"/><br/>
		<input type="submit" value="회원가입"/>
	</form>
</body>
<script></script>
</html>