<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
	<style></style>
</head>
<body>
	<h3>단일 파일 업로드</h3>
	<form action="upload" method="post" enctype="multipart/form-data"> <!-- uoload 로 post 방식으로 요청 전송 -->
		<input type="text" name="title"/>
		<input type="file" name="uploadFile"/>
		<input type="submit" value="전송"/>
	</form>

	<h3>멀티 파일 업로드</h3>
	<form action="multiupload" method="post" enctype="multipart/form-data">
		<input type="file" name="files" multiple="multiple"/>
		<input type="submit" value="전송"/>
	</form>	
	
</body>
<script></script>
</html>