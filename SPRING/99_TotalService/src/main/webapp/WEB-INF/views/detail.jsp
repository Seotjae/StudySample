<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style>
		table, th, td{
			border : 1px solid black;
			border-collapse: collapse;
			padding: 5px;
		}	
	</style>
</head>
<body>
	<div>${loginBox}</div>
	<table>
		<tr>
			<th>글번호</th>
			<td>${bbs.idx}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${bbs.bHit}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${bbs.subject}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${bbs.content}</td>
		</tr>
	</table>
	<button onclick="location.href='list'">리스트</button>
	<button onclick="location.href='updateForm/'+${bbs.idx}">수정</button>
</body>
<script></script>
</html>