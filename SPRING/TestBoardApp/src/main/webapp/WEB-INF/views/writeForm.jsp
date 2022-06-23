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
	<form action="write" method="post">	
		<table>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="user_name"/></td>
			</tr>
			<tr>
				<th>글 제목</th>
				<td><input type="text" name="subject"/></td>
			</tr>
			<tr>
				<th>글 내용</th>
				<td><textarea name="content"></textarea></td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="button" onclick="location.href='./'" value="리스트">
					<input type="submit" value="작성"/>
				</th>
			</tr>
		</table>
	</form>
</body>
<script>
</script>
</html>