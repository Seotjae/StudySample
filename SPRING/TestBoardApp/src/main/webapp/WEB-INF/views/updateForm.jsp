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
	<form action="update" method="post">
		<input type="hidden" name="idx" value="${content.idx}">	
		<table>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="user_name" value="${content.user_name}"/></td>
			</tr>
			<tr>
				<th>글 제목</th>
				<td><input type="text" name="subject" value="${content.subject}"/></td>
			</tr>
			<tr>
				<th>글 내용</th>
				<td><textarea name="content">${content.content}</textarea></td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="button" onclick="location.href='./'" value="목록">
					<input type="submit" value="수정"/>
				</th>
			</tr>
		</table>
	</form>
</body>
<script>
</script>
</html>