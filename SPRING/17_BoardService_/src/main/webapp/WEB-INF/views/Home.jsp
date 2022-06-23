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
	<!-- 상세보기 삭제 글쓰기 -->
	<button onclick="location.href='./writeForm'">글쓰기</button>
	<table>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>삭제</th>
		</tr>
		<c:if test="${size == 0}">
			<tr>
				<td colspan="5">작성된 글이 없습니다.</td>
			</tr>
		</c:if>
		<c:if test="${size > 0}">
			<c:forEach items="${list}" var="bbs">
				<tr>
					<td>${bbs.idx}</td>
					<td><a href="detail?idx=${bbs.idx}">${bbs.subject}</a> </td>
					<td>${bbs.user_name}</td>
					<td>${bbs.bHit}</td>
					<td><a href="./delete?idx=${bbs.idx}">삭제</a></td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
<script>
</script>
</html>