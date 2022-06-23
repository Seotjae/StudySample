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
			<th>글번호<th>
			<td>${info.idx}</td>
		</tr>	
		<tr>
			<th>제목</th>
			<td>${info.subject} <b>(${info.bHit})</b></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${info.user_name}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${info.content}</td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="button" onclick="location.href='./'" value="리스트">
				<input type="button" onclick="location.href='./updateForm?idx=${info.idx}'" value="수정">
				<input type="button" onclick="del()" value="삭제">
			</th>
		</tr>
	</table>
</body>
<script>
	function del() {
		var yn=confirm("정말 이 글을 삭제 하시겠습니까?")
		if (yn) {
			location.href='./delete?idx=${info.idx}';
		}
	}

</script>
</html>