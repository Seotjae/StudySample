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
	<div>${loginBox}</div>
	<table>
		<tr>
			<th>글번호</th>
			<td>${detail.idx}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${detail.user_name}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${detail.bHit}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${detail.reg_date}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${detail.subject}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${detail.content}</td>
		</tr>
	</table>

	
</body>
<script>
</script>
</html>