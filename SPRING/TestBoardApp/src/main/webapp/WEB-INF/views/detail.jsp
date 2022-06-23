<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<link rel="stylesheet" type="text/css" href="resources/css/common.css">
	<style>
	</style>
</head>
<body>
	<table>
		<tr>
			<th>글번호</th>
			<td>${content.idx}</td>
			<th>작성자</th>
			<td>${content.user_name}</td>
			<th>작성일</th>
			<td>${content.reg_date}</td>
			<th>조회수</th>
			<td>${content.bHit}</td>
		</tr>
		<tr>
			<th>글 제목</th>
			<td colspan="7">${content.subject}</td>
		</tr>
		<tr>
			<th>글 내용</th>
			<td colspan="7">${content.content}</td>
		</tr>
		<tr>
			<th colspan="8">
				<input type="button" onclick="location.href='./'" value="목록">
				<input type="button" onclick="location.href='./updateForm?idx=${content.idx}'" value="수정">
				<input type="button" onclick="location.href='./del?idx=${content.idx}'" value="삭제">
			</th>
		</tr>
	</table>
	
</body>
<script>
</script>
</html>