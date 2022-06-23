<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style>
		table, td, th {
			border: 1px solid black;
			border-collapse: collapse;
			padding: 5px;
		}
	</style>
</head>
<body>
	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>상세보기</th>
			<th>삭제</th>
		</tr>
		<c:forEach var="item" items="${list}">
			<tr>
				<th>${item.id}</th>
				<th>${item.name}</th>
				<th><a href="detail?id=${item.id}">상세보기</a></th>
				<th><a href="del?id=${item.id}">삭제</a></th>
			</tr>
		</c:forEach>	
	</table>
</body>
<script>
</script>
</html>