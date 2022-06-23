<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<link rel="stylesheet" href="resources/css/common.css"/>
	<style>
	</style>
</head>
<body>
	<input type="button" value="글작성" onclick="location.href='./writeForm'"/>
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr>
				<td>${item.idx}</td>
				<td><a href="detail?idx=${item.idx}">${item.subject}</a></td>
				<td>${item.user_name}</td>
				<td>${item.bHit}</td>
			</tr>
		</c:forEach>
	</table>
</body>
<script>
</script>
</html>