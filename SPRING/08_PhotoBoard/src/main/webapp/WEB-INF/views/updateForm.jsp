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
	<form action="update" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>제목</th>
				<td>
					<input type="hidden" name="idx" value="${dto.idx}">
					<input type="text" name="subject" value="${dto.subject}"/>
				</td> 
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="user_name" value="${dto.user_name}"/></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="content">${dto.content}</textarea></td>
			</tr>
			<tr>
				<th>사진</th>
				<td>
					<!-- 사진 추가 -->
					<input type="file" name="photos" multiple="multiple"/>
					<!-- 현재 업로드된 사진 삭제 -->
					<c:forEach items="${photos}" var="photo">
						<img src="/photo/${photo.newFileName}" width="250"/><br/><br/>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<th colspan="2">
					<input type="button" onclick="location.href='./'" value="리스트">
					<button>저장</button>
				</th>
			</tr>
		</table>
	</form>
</body>
<script>
</script>
</html>