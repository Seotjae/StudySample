<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style>
		textarea {
			width: 300px;
			min-height:400px;
			resize: none;
		}
		input {
			width: 100%;
		}
	</style>
</head>
<body>
	<form action="write" method="post">
		<table>
			<tr>
				<th>작성자</th>
				<td>
					<input type="text" name="user_name"/>
				</td>
				<td>
					<button>완료</button>
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="2">
					<input type="text" name="subject"/>
				</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="2">
					<textarea name="content"></textarea>
				</td>
			</tr>
		</table>
	</form>
	
</body>
<script>
</script>
</html>