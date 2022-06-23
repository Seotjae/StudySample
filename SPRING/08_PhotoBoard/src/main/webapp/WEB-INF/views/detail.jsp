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
	<table>
		<tr>
			<th>글번호</th>
			<td>${dto.idx}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.subject} (${dto.bHit})</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${dto.user_name}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${dto.reg_date}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${dto.content}</td>
		</tr>
		<tr>
		<c:if test="${photos.size()>0}">
		<tr>
			<th>사진</th>
			<td>
				<c:forEach items="${photos}" var="photo">
					<img src="/photoFile/${photo.newFileName}" width="250px"/><br/><br/>
				</c:forEach>
			</td>
		</tr>		
		</c:if>
			<th colspan="2">
				<input type="button" value="리스트" onclick="location.href='./'"/>
				<input type="button" value="수정" onclick="location.href='./updateForm?idx=${dto.idx}'"/>
				<input type="button" value="삭제" onclick="location.href='./delete?idx=${dto.idx}'"/>
			</th>
		</tr>
	</table>
	
</body>
<script>
</script>
</html>